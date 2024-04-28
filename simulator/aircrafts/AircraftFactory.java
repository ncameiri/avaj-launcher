package simulator.aircrafts;
import coordinates.*;
import simulator.Simulator;
import simulator.weather.WeatherProvider;


//Singleton -> Only 1 object instance of this type
public class AircraftFactory {
    private static AircraftFactory instance = null;

    private AircraftFactory(){}

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates, Number unique_id) throws Exception{
        if (instance == null) {
            instance = new AircraftFactory();
        }
        if(p_type.equals("Helicopter"))       
            return new Helicopter(Simulator.airc_id, p_name, p_coordinates, unique_id);
        else if(p_type.equals("JetPlane"))
            return new JetPlane(Simulator.airc_id, p_name, p_coordinates, unique_id);
        else if(p_type.equals("Baloon"))
            return new Baloon(Simulator.airc_id, p_name, p_coordinates, unique_id);
        throw new Exception("Wrong type of Flyable");
    }       
}
