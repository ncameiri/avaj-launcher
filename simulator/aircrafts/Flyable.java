package simulator.aircrafts;
import simulator.weather.WeatherTower;
public abstract class Flyable {
	protected WeatherTower weatherTower = null;
	//Abstract methods to be implemented by subclasses (Balloon, JetPlane or Helicopter)
	public int updateConditions(){return 0;};
	public void registerTower(WeatherTower p_tower){};
	
	public String get_name(){return null;}

	public String get_type(){return null;}

	public String get_prefix(){return null;}

}

    

