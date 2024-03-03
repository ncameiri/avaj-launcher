package simulator;
import simulator.*;
import simulator.aircrafts.*;
import simulator.weather.WeatherTower;

import java.util.*;
public class Tower{
    List<Flyable> observers= new ArrayList<Flyable>();

    	public void register(Flyable flyable) {
		observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}
	
	protected void conditionsChanged() {
		
	}

	public void check_all_aircrafts(){
		System.out.println(observers);
	}
}
