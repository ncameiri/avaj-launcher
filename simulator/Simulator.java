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
  static FileWriter output_file=null;
  //WeatherTower creation to be compatible with
  //registerTower Method
  private static WeatherTower p_tower = new WeatherTower();
  public int validate_type_flyable(String flyable_to_test){
      return 0;
  }

  public static void write_out_file(String str){
    try{
    output_file.write(str+"\n");
    }catch (IOException e) {
      System.out.println("An error occurred writing to simulation file.");
      e.printStackTrace();
      return;
    }

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
        Flyable curr_fly=AircraftFactory.newAircraft(AircraftType, Register_Id, coord,++airc_id);
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
      File scenario_file = new File(args[0]);
      //Overwrite previous content of file
      output_file= new FileWriter("simulation.txt");
      Scanner file_reader = new Scanner(scenario_file);
      file_parse(file_reader);
      file_reader.close();
      //System.out.println(sim_loops);
 
      //DEBUG- check all registered aircrafts
      //p_tower.check_all_aircrafts();
      //Loop all over the simulation cycles
      while(sim_loops>0){
      p_tower.changeWeather();
      sim_loops--;
    }
      //p_tower.check_all_aircrafts();
      //WeatherTower tower = new WeatherTower();

      output_file.close();
    } catch (Exception e) {
      System.out.println("An error occurred opening / reading file.");
      e.printStackTrace();
      return;
    }
      return;
    }
    
}