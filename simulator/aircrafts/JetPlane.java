package simulator.aircrafts;

import simulator.Coordinates;
import simulator.weather.WeatherTower;
public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
            super(p_id, p_name, p_coordinate);  
            System.out.println("Jetplane constructor");
    }
    public void updateConditions(){
    }
    public void registerTower(WeatherTower p_tower){
        this.weatherTower= p_tower;
        this.weatherTower.register(this);
    }
}