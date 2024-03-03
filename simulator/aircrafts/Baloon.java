package simulator.aircrafts;

import coordinates.*;
import simulator.weather.WeatherTower;
//Ballon inherits from Aircraft and implements Flyable Interface(define methods existent on this interface for each Aircraft Object)
public class Baloon extends Aircraft{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate){
              super(p_id, p_name, p_coordinate);  
              System.out.println("ballon constructor");
    }

    public void updateConditions(){
    }
    public void registerTower(WeatherTower p_tower){
        this.weatherTower= p_tower;
        this.weatherTower.register(this);
    }
}
