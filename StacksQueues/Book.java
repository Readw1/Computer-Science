public class Book
{
    
    private String name;
    private int hour;
    private int minute;
    public Book(String inName, String intime)
    {
        name = inName;
        
        String[] times = intime.split(":");
        
        hour = Integer.parseInt(times[0]);
        minute = Integer.parseInt(times[1]);
    }

    public String getName(){
        return name;
    }
    public String toString()
    {
        
        return "Name: " + name + ". Timestamp: " + hour + ":" + minute + ".";
    }
}
