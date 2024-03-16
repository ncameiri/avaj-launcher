package simulator.aircrafts;

import coordinates.*;
import simulator.weather.WeatherTower;
//Class (Balloon, JetPlane or Helicopter) extends(inherits(fields and methods) properties from) Aircraft(superclass)
public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
            super(p_id, p_name, p_coordinate);  
            //System.out.println("Jetplane constructor");
    }
    public void updateConditions(){
        this.updateCoordinates(this.weatherTower.getWeather(this.coordinates));
    }
    public void registerTower(WeatherTower p_tower){
        this.weatherTower= p_tower;
        this.weatherTower.register(this);
    }
    public String get_name(){return this.name;}

    public String get_type(){return "JETPLANE";}
}