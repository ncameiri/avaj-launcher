package simulator;
import simulator.aircrafts.*;

import java.util.*;
public class Tower{
    private List<Flyable> observers= new ArrayList<Flyable>();

    	public void register(Flyable flyable) {
		observers.add(flyable);
		Simulator.write_out_file("Tower says: "+flyable.get_prefix() + " registered to weather tower.");
		System.out.println("Tower says: "+flyable.get_prefix() + " registered to weather tower.");
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}
	
	protected void conditionsChanged() {
		
		//Using Iterator to go through all the aircrafts list
		Iterator<Flyable> iterator = observers.iterator();

		//Temporary List for deletion after update condition (coordinates) based on weather
		// only after while to avoid loose iterator position when deleting an element of Array
		List<Flyable>  del_list = new ArrayList<Flyable>();
		
		while(iterator.hasNext()){
			Flyable el=iterator.next();
			if(el.updateConditions() == 1){
				Simulator.write_out_file("Tower says: "+el.get_prefix() + " unregistered from weather tower.");
				System.out.println("Tower says: "+el.get_prefix() + " unregistered from weather tower.");
				del_list.add(el);
			}
		}

		//Temp list for deletions
		iterator= del_list.iterator();
		while(iterator.hasNext()){
			unregister(iterator.next());
		}

	}

	public void check_all_aircrafts(){
		System.out.println(observers);
	}

	public void check_duplicated_id(String id_to_check) throws Exception{
		
		Iterator<Flyable> iterator = observers.iterator();
		
		while(iterator.hasNext()){
			if(iterator.next().get_name().equals(id_to_check))
				  throw new Exception("Duplicated id");
		}

	}
}
