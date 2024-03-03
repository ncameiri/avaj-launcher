package simulator.aircrafts;
import simulator.*;
import simulator.weather.WeatherTower;
public class Aircraft extends Flyable {
    // TYPE NAME LONGITUDE LATITUDE HEIGHT
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate){
        
    }
}
