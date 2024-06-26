package simulator.weather;

import coordinates.*;
//Singleton - Unique Object - Unique access point - 1 instance of object
public class WeatherProvider {
    //private static singleton
    private static WeatherProvider instance =new WeatherProvider(null);
    private String[] weather;
    
    
    private WeatherProvider(String[] value){
        String[] kind_of_wheather={"RAIN", "FOG", "SUN", "SNOW"};
        this.weather =  kind_of_wheather;
    }

    public static WeatherProvider get_WeatherInstance(){
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates){
        int lon=p_coordinates.getLongitude();
        int lat=p_coordinates.getLatitude();
        int hei=p_coordinates.getHeight();
        //Avoid division by 0
        if(hei == 0){
            hei = lon + lat + 1;
        }
        float index_= (float) Math.floor((lon * lat / hei));
        return instance.weather[Math.round(index_%4)];
    }
}
