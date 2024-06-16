package coordinates;

public class Coordinates {
    private int longitude;
    private int latitute;
    private int height;
    
    //Throws Exception send exception to main func and stops at that point the program execution
    //try catch can't be on this function otherwise it will only stop constructor and not all program
    public Coordinates(int p_longitude, int p_latitude, int p_height) throws Exception{
            if(p_height < 0){
            throw new Exception("height out of bounds Exception");
            }

            if(p_height > 100)
                this.height = 100; 
            else
                this.height = p_height;

            if(p_longitude < 0 || p_latitude < 0){
            throw new Exception("latitude or longitude out of bounds Exception");    
            }
            this.longitude = p_longitude;
            this.latitute = p_latitude;
       
    }
    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitute;
    }
    public int getHeight(){
        return this. height;
    }

    public void UpdateHelicopterRain(){
        this.longitude+=5;
    }

    public void UpdateHelicopterFog(){
        this.longitude+=1;
    }

    public void UpdateHelicopterSun(){
        this.longitude+=10;
        if(this.height + 2 > 100)
            this.height=100;
        else
            this.height+=2;
    }

    public void UpdateHelicopterSnow(){
        this.height-=12;
    }

    public void UpdateJetPlaneRain(){
        this.latitute+=5;
    }

    public void UpdateJetPlaneFog(){
        this.latitute+=1;
    }

    public void UpdateJetPlaneSun(){
        this.latitute+=10;
        if(this.height + 2 > 100)
            this.height=100;
        else
            this.height+=2;
    }

    public void UpdateJetPlaneSnow(){
        this.height-=7;
    }

    public void UpdateBaloonRain(){
        this.height-=5;
    }

    public void UpdateBaloonFog(){
        this.height-=3;
    }

    public void UpdateBaloonSun(){
        this.longitude+=2;
        if(this.height + 4 > 100)
            this.height=100;
        else
            this.height+=4;
    }

    public void UpdateBaloonSnow(){
        this.height-=15;
    }
}
