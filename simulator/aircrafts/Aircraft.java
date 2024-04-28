package simulator.aircrafts;
import coordinates.*;
import simulator.*;
import simulator.weather.WeatherTower;
public class Aircraft extends Flyable {
    // TYPE NAME LONGITUDE LATITUDE HEIGHT
    //1-> Helicopter, 2-> JetPlane, 3-> Baloon
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate){
        this.name=p_name;
        this.coordinates=p_coordinate;
        this.id=p_id;
    }

    //Added method to update Coordinates depending
    // on weather and rules on subject
    protected int updateCoordinates(String kind_of_wheather){
        //System.out.println(kind_of_wheather);
        //System.out.println(this.get_prefix());

        var a1=this.coordinates.getHeight();
        var b2=this.coordinates.getLongitude();
        var c3= this.coordinates.getLatitude();
        //System.out.println(a1+" "+b2+" "+c3);
        switch(this.get_type()) {
            case "HELICOPTER":
                switch(kind_of_wheather){
                    case "RAIN":
                        this.coordinates.UpdateHelicopterRain();
                        break;
                    case "FOG":
                        this.coordinates.UpdateHelicopterFog();
                        break;
                    case "SUN":
                        this.coordinates.UpdateHelicopterSun();
                        break;
                    case "SNOW":
                        this.coordinates.UpdateHelicopterSnow();
                        break;
                }
                break;            
            case "JETPLANE":
                switch(kind_of_wheather){
                    case "RAIN":
                        this.coordinates.UpdateJetPlaneRain();
                        break;
                    case "FOG":
                        this.coordinates.UpdateJetPlaneFog();
                        break;
                    case "SUN":
                        this.coordinates.UpdateJetPlaneSun();
                        break;
                    case "SNOW":
                        this.coordinates.UpdateJetPlaneSnow();
                        break;
                }
            break;  
            case "BALOON":
                switch(kind_of_wheather){
                    case "RAIN":
                        this.coordinates.UpdateBaloonRain();
                        break;
                    case "FOG":
                        this.coordinates.UpdateBaloonFog();
                        break;
                    case "SUN":
                        this.coordinates.UpdateBaloonSun();
                        break;
                    case "SNOW":
                        this.coordinates.UpdateBaloonSnow();
                        break;
                }
            break;
        }
        //Unregister - Aircraft lands height 0
        if(this.coordinates.getHeight() <= 0){
           return 1;
        }
        var a=this.coordinates.getHeight();
        var b=this.coordinates.getLongitude();
        var c= this.coordinates.getLatitude();
        //System.out.println(a+" "+b+" "+c);
        return 0;

    }
}
