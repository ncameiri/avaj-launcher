package simulator.aircrafts;

import coordinates.*;
import simulator.Simulator;
import simulator.weather.WeatherTower;
//Class (Balloon, JetPlane or Helicopter) extends(inherits(fields and methods) properties from) Aircraft(superclass)
public class Helicopter  extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate, Number unique_id){
        super(p_id, p_name, p_coordinate);
    }
    public int updateConditions(){
        String _weather=this.weatherTower.getWeather(this.coordinates);
        int last_message= this.updateCoordinates(_weather);
        if(last_message == 1){
            Simulator.write_out_file(this.get_prefix()+": landing.");
            System.out.println(this.get_prefix()+": landing.");
        }
        else{
            switch (_weather) {
                case "RAIN":
                    Simulator.write_out_file(this.get_prefix()+": RAIN.");
                    System.out.println(this.get_prefix()+": RAIN.");
                    break;
            
                case "FOG":
                    Simulator.write_out_file(this.get_prefix()+": FOG.");
                    System.out.println(this.get_prefix()+": FOG.");
                    break;
                
                case "SUN":
                    Simulator.write_out_file(this.get_prefix()+": SUN.");
                    System.out.println(this.get_prefix()+": SUN.");
                    break;
                case "SNOW":
                    Simulator.write_out_file(this.get_prefix()+": SNOW.");
                    System.out.println(this.get_prefix()+": SNOW.");
                    break;
            }
        }
        return last_message;
    }
    public void registerTower(WeatherTower p_tower){
        this.weatherTower= p_tower;
        this.weatherTower.register(this);
    }
    public String get_name(){return this.name;}
    public String get_prefix(){return "Helicopter"+"#"+this.name+"("+this.id+")";}

    public String get_type(){return "HELICOPTER";}
}
