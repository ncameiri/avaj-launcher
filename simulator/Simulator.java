package simulator;
import java.io.*;
import java.util.*;
import coordinates.*;
import simulator.aircrafts.Aircraft;
import simulator.aircrafts.AircraftFactory;
import simulator.aircrafts.Helicopter;
import simulator.aircrafts.Flyable;
import simulator.weather.WeatherProvider;
import simulator.weather.WeatherProvider.*;
import simulator.weather.WeatherTower;

public class Simulator {
  static public int airc_id=0;
  static int sim_loops=-1;
  //Tower creation
  private static WeatherTower p_tower = new WeatherTower();
  public int validate_type_flyable(String flyable_to_test){
      return 0;
  }

  public static  int file_parse(Scanner scenario_reader) throws Exception{
   
    String data = scenario_reader.nextLine();
    sim_loops= Integer.parseInt(data);
    if(sim_loops <= 0)
      throw new Exception("Wrong number of simulation loops");
     while (scenario_reader.hasNextLine()) {
        //if(data){
          data = scenario_reader.nextLine();
          
        StringTokenizer tokens = new StringTokenizer(data.trim());
         // while (tokens.hasMoreTokens()) {
        String AircraftType = tokens.nextToken();
        String Register_Id = tokens.nextToken();
        int Long = Integer.parseInt(tokens.nextToken());
        int Lati= Integer.parseInt(tokens.nextToken());
        int Heig = Integer.parseInt(tokens.nextToken());
        Coordinates coord = new Coordinates(Long,Lati,Heig);
        p_tower.check_duplicated_id(Register_Id);
        //System.out.println(data);
        Flyable curr_fly=AircraftFactory.newAircraft(AircraftType, Register_Id, coord);
        curr_fly.registerTower(p_tower);         
    }
     return 0;
   
  }
  
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Please provide 1 simulation file as 1st argument"); 
			return;
		}
    try {
      System.out.println(args[0]);
      File scenario_file = new File(args[0]);
      Scanner file_reader = new Scanner(scenario_file);
      file_parse(file_reader);
      System.out.println(sim_loops);
 
      //DEBUG- check all registered aircrafts
      p_tower.check_all_aircrafts();

      WeatherTower tower = new WeatherTower();

      file_reader.close();
    } catch (Exception e) {
      System.out.println("An error occurred opening / reading file.");
      e.printStackTrace();
      return;
    }

      //TESTES
      //Coordinates new_coordinates = new Coordinates(654,33,20);
      //AircraftFactory.newAircraft("1","NoName", new Coordinates(654,33,20));
      // String[] tt={"1", "2", "3", "4"};
      //  //WeatherProvider ne= new WeatherProvider(null);
      //  try{
      //   Random randa = new Random();
      //   Random randb = new Random();
      //   Random randc = new Random();
      //    Coordinates a = new Coordinates(Math.abs(randa.nextInt(100)),Math.abs(randb.nextInt(100)),Math.abs(randc.nextInt(100)));
      //  String res_1=WeatherProvider.getCurrentWeather(a);
      //  System.out.println(res_1);
      //  res_1=WeatherProvider.getCurrentWeather(a);
      //  System.out.println(res_1);
      //  res_1=WeatherProvider.getCurrentWeather(a);
      //  System.out.println(res_1);
      //  res_1=WeatherProvider.getCurrentWeather(a);
      //  System.out.println(res_1);
      //  }
      //  catch(Exception e){e.printStackTrace();}
      // WeatherProvider n2e=  new WeatherProvider(tt);
      return;
    }
    
  //}
}