
public class PriString
{
    private String info;
    private int priority;
    public PriString(String s, int p){
        info = s;
        priority = p;
    }
    
    public String toString( ){ 
        return info + "   Pri= #" + priority;
    }
    
    public String getInfo(){
        return info;
    }
    
    public int getPriority(){
        return priority;
    }
}
