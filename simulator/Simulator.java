package simulator;

//import simulator.aircrafts.Flyable;
import java.io.*;
import java.util.*;

import simulator.aircrafts.Aircraft;
import simulator.aircrafts.AircraftFactory;
import simulator.aircrafts.Flyable;
import simulator.weather.WeatherProvider;
import simulator.weather.WeatherTower;
import simulator.Coordinates;
public class Simulator {
  //Flyable inst = new Flyable();
  static int sim_loops=-1;
  public static int file_parse(Scanner scenario_reader){
   try{ 
    String data = scenario_reader.nextLine();
    sim_loops= Integer.parseInt(data);
    if(sim_loops < 0)
      throw new Exception("Wrong number of simulation loops");
     while (scenario_reader.hasNextLine()) {
        data = scenario_reader.nextLine();
        System.out.println(data);
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
    /*if (args.length < 1) {
      System.out.println("Please provide 1 simulation file as 1st argument"); 
			return;
		}
    try {
      //if(1 == 1)
      //throw new Exception("aa");
      System.out.println(args[0]);
      File scenario_file = new File(args[0]);
      Scanner file_reader = new Scanner(scenario_file);
      file_parse(file_reader);
       //System.out.println(sim_loops);
     
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
      e.printStackTrace();*/


      //TESTES
      //Coordinates new_coordinates = new Coordinates(654,33,20);
      //AircraftFactory.newAircraft("1","NoName", new Coordinates(654,33,20));
      String[] tt={"1", "2", "3", "4"};
      WeatherProvider ne=  new WeatherProvider(tt);
      String res_1=ne.getCurrentWeather(new Coordinates(0,0,0));
      System.out.println(res_1);
      res_1=ne.getCurrentWeather(new Coordinates(0,0,0));
      System.out.println(res_1);
      res_1=ne.getCurrentWeather(new Coordinates(0,0,0));
      System.out.println(res_1);
      res_1=ne.getCurrentWeather(new Coordinates(0,0,0));
      System.out.println(res_1);
      WeatherProvider n2e=  new WeatherProvider(tt);
      return;
    }
    
  //}
}