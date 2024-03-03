package simulator.aircrafts;
import simulator.weather.WeatherTower;
public abstract class Flyable {
	protected WeatherTower weatherTower = null;
	public void updateConditions(){};
	public void registerTower(WeatherTower p_tower){};
	public String get_name(){return null;}
}

    

