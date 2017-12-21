
public class Time
{
    private int hours;
    private int minutes;
    
    public Time(int inHours, int inMinutes){
        hours = inHours;
        minutes = inMinutes;
    }
    
    public Time(String inTime){
        String[] times = inTime.split(":");
        
        hours = Integer.parseInt(times[0]);
        minutes = Integer.parseInt(times[1]);
    }
    
    public int getMins(){
        return minutes;
    }
    
    public int getHours(){
        return hours;
    }
    
    public String toString(){
        return hours + ":" + minutes;
    }
    
}
