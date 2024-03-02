package simulator;

public class Coordinates {
    int longitude;
    int latitute;
    int height;
    
    Coordinates(int p_longitude, int p_latitude, int p_height){
        try{
            if(p_height < 0 || p_height > 100){
            throw new Exception("height out of bounds Exception");
            }

            if(p_longitude < 0 || p_latitude < 0){
            throw new Exception("latitude or longitude out of bounds Exception");    
            }
            this.height = p_height;
            this.longitude = p_longitude;
            this.latitute = p_latitude;

        }
        catch(Exception e){
            e.printStackTrace();
        }
       
    }
    int getLongitude(){
        return this.longitude;
    }
    int getLatitude(){
        return this.latitute;
    }
    int getHeight(){
        return this. height;
    }
}
