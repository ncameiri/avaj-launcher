package simulator.weather;

import coordinates.Coordinates;
import simulator.Tower;
public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coordinates){
        return WeatherProvider.get_WeatherInstance().getCurrentWeather(p_coordinates);}
    public void changeWeather(){
        this.conditionsChanged();
    }
}
