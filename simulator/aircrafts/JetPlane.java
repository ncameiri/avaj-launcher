package simulator.aircrafts;

import simulator.Coordinates;

public class JetPlane extends Aircraft implements Flyable{
    JetPlane(long p_id, String p_name, Coordinates p_coordinate){
            super(p_id, p_name, p_coordinate);  
    }
    void updateConditions(){

    }
}
