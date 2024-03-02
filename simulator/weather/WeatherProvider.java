package simulator.weather;
import simulator.Coordinates;
import java.util.Random;
//Singleton - Unique Object - Unique access point - 1 instance of object
public class WeatherProvider {
    //private static singleton
    private static WeatherProvider instance;
    public String[] weather;
    
    public WeatherProvider(String[] value){
        String[] kind_of_wheather={"RAIN", "FOG", "SUN", "SNOW"};
        System.out.println("Constructor");
        this.weather =  kind_of_wheather;
    }
    public String getCurrentWeather(Coordinates p_coordinates){
        //
        System.out.println("Func wheather");
        if (instance == null) {
            instance = new WeatherProvider(null);
        }
        Random rand = new Random();
        return instance.weather[rand.nextInt(4)];
    }
}
