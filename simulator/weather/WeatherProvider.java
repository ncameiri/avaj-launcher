package simulator.weather;
import simulator.Coordinates;
import java.util.Random;
//Singleton - Unique Object - Unique access point - 1 instance of object
public class WeatherProvider {
    //private static singleton
    private static volatile WeatherProvider instance = null;
    public String[] weather;
    
    
    private WeatherProvider(String[] value){
        String[] kind_of_wheather={"RAIN", "FOG", "SUN", "SNOW"};
        System.out.println("Constructor1");
        this.weather =  kind_of_wheather;
        //instance = instance;
    }
    public static synchronized String getCurrentWeather(Coordinates p_coordinates){
        System.out.println("Func wheather");
        if (instance == null) {
            instance = new WeatherProvider(null);
        }
        //Random rand = new Random();
        //return instance.weather[rand.nextInt(4)];

        int lon=p_coordinates.getLongitude();
        int lat=p_coordinates.getLatitude();
        int hei=p_coordinates.getHeight();
        //Avoid division by 0
        if(hei == 0){
            hei = lon + lat + 1;
        }
        float index_= (float) Math.floor((lon * lat / hei));
        System.out.println(Math.round(index_%4));
        return instance.weather[Math.round(index_%4)];
    }
}
