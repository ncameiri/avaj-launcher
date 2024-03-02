package simulator;

//import simulator.aircrafts.Flyable;
import java.io.*;
import java.util.*;

import simulator.aircrafts.Aircraft;
import simulator.aircrafts.AircraftFactory;
import simulator.aircrafts.Helicopter;
import simulator.aircrafts.Flyable;
import simulator.weather.WeatherProvider;
import simulator.weather.WeatherProvider.*;
import simulator.weather.WeatherTower;
import simulator.Coordinates;
public class Simulator {
  //Flyable inst = new Flyable();
  static int airc_id=0;
  static int sim_loops=-1;
  public static int file_parse(Scanner scenario_reader) throws Exception{
   try{ 
    String data = scenario_reader.nextLine();
    sim_loops= Integer.parseInt(data);
    if(sim_loops < 0)
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
        //Aircraft air1 = new Aircraft(airc_id++,Register_Id,coord); 
         System.out.println(AircraftType);
        System.out.println(airc_id);
        if(AircraftType.equals("Helicopter")){
          Helicopter heli = new Helicopter(airc_id++,Register_Id,coord);
        }
    //}
     //System.out.println("New Line");
      //}
    }
     return 0;
   }
   catch(Exception e) {
      System.out.println("An error occurred opening / reading file.");
      e.printStackTrace();
      return -1;
    }
  }
  
  public static void main(String[] args) {
    //simulator.aircrafts.Flyable.cenas();
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
     
     // sim_loops= Integer.parseInt(data);
      //  System.out.println(sim_loops);
      // while (file_reader.hasNextLine()) {
      //   data = file_reader.nextLine();
      //   //System.out.println(data);
      // }

      WeatherTower tower = new WeatherTower();

      file_reader.close();
    } catch (Exception e) {
      System.out.println("An error occurred opening / reading file.");
      e.printStackTrace();
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