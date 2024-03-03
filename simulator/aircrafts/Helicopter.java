package simulator.aircrafts;

import simulator.Coordinates;
import simulator.weather.WeatherTower;
public class Helicopter  extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
        //System.out.println("Helicopter created %s, %s");
        //System.out.print(p_name);
        //System.out.print(p_id);
        System.out.println("helicopter constructor");
    }
    public void updateConditions(){
    }
    public void registerTower(WeatherTower p_tower){
        this.weatherTower= p_tower;
        this.weatherTower.register(this);
    }
}
