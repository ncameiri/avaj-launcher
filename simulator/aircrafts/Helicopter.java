package simulator.aircrafts;

import simulator.Coordinates;

public class Helicopter  extends Aircraft implements Flyable{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
        //System.out.println("Helicopter created %s, %s");
        //System.out.print(p_name);
        //System.out.print(p_id);
    }
    void updateConditions(){

    }
}
