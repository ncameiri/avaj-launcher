package simulator.aircrafts;

import simulator.Coordinates;

//Singleton - Unique Object - Unique access point - 1 instance of object
public class AircraftFactory {
    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        return new Helicopter(0, p_name, p_coordinates);
    }
    
}
