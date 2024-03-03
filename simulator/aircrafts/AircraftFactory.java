package simulator.aircrafts;
import coordinates.*;
import simulator.Simulator;
import simulator.weather.WeatherProvider;

public class AircraftFactory {
    private static volatile AircraftFactory instance = null;

    private AircraftFactory(){}
    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws Exception{
        if (instance == null) {
            instance = new AircraftFactory();
        }
        if(p_type.equals("Helicopter"))       
            return new Helicopter(Simulator.airc_id++, p_name, p_coordinates);
        else if(p_type.equals("JetPlane"))
            return new JetPlane(Simulator.airc_id++, p_name, p_coordinates);
        else if(p_type.equals("Baloon"))
            return new Baloon(Simulator.airc_id++, p_name, p_coordinates);
        throw new Exception("Wrong type of Flyable");
    }       
}
