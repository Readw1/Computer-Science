
public class Info
{
    private String name;
    private int acctNum;
    
    public Info(String inN, int inNum){
        name = inN;
        acctNum = inNum;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAcct(){
        return acctNum;
    }
    
    public String toString(){
        return name + " " + acctNum;
    }
    
}
