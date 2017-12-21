
public class Package
{
    private String code;
    private Time time;
    private int priority;
    
    public Package(String inCode, Time inTime, int inprior){
        code = inCode;
        time = inTime;
        priority = inprior;
    }
    
    public String getCode(){
        return code;
    }
    
    public Time getTime(){
        return time;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public String toString(){
        return "Code: " + code + "\t" + "Time: " + time + "\t" + "Priority: " + priority;
    }
}
