package simulator.aircrafts;

import coordinates.*;
import simulator.Simulator;
import simulator.weather.WeatherTower;
//Ballon inherits from Aircraft and implements Flyable Interface(define methods existent on this interface for each Aircraft Object)
public class Baloon extends Aircraft{
    public Baloon(long p_id, String p_name, Coordinates p_coordinate, Number unique_id){
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
                    Simulator.write_out_file(this.get_prefix()+": Damn you rain! You messed up my baloon.");
                    System.out.println(this.get_prefix()+": Damn you rain! You messed up my baloon.");
                    break;
            
                case "FOG":
                    Simulator.write_out_file(this.get_prefix()+": It's a foggy day!");
                    System.out.println(this.get_prefix()+": It's a foggy day!");
                    break;
                
                case "SUN":
                    Simulator.write_out_file(this.get_prefix()+": Let's enjoy the good weather and take some pics.");
                    System.out.println(this.get_prefix()+": Let's enjoy the good weather and take some pics.");
                    break;
                case "SNOW":
                    Simulator.write_out_file(this.get_prefix()+": It's snowing. We're gonna crash.");
                    System.out.println(this.get_prefix()+": It's snowing. We're gonna crash.");
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
    public String get_prefix(){return "Baloon"+"#"+this.name+"("+this.id+")";}

    public String get_type(){return "BALOON";}
}
