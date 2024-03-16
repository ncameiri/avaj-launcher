package coordinates;

public class Coordinates {
    private int longitude;
    private int latitute;
    private int height;
    
    //O Throws Exception vai enviar a exception para o main e interromper o código, o try catch não poderá estar na função caso contrario apenas interrompe o constructor, continuando a execução do main
    public Coordinates(int p_longitude, int p_latitude, int p_height) throws Exception{
        //try{
            if(p_height < 0 || p_height > 100){
            throw new Exception("height out of bounds Exception");
            }

            if(p_longitude < 0 || p_latitude < 0){
            throw new Exception("latitude or longitude out of bounds Exception");    
            }
            this.height = p_height;
            this.longitude = p_longitude;
            this.latitute = p_latitude;
        //}
        // catch(Exception e){
        //     e.printStackTrace();
            
        // }
       
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
        this.height+=4;
    }

    public void UpdateBaloonSnow(){
        this.height-=15;
    }
}
