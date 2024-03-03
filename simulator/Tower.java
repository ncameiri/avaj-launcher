package simulator;
import simulator.*;
import simulator.aircrafts.*;
import simulator.weather.WeatherTower;

import java.util.*;
public class Tower{
    private List<Flyable> observers= new ArrayList<Flyable>();

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

		public void check_duplicated_id(String id_to_check) throws Exception{
		
		Iterator<Flyable> iterator = observers.iterator();
		
		//simple iteration
		while(iterator.hasNext()){
			//int i = (int) iterator.next();
			if(iterator.next().get_name().equals(id_to_check))
				  throw new Exception("Duplicated id");
		}

	}
}
