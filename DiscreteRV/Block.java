
public class Block
{
    // instance variables - replace the example below with your own
    private int weight;

    /**
     * Constructor for objects of class Block
     */
    public Block(){
        NormDev getWt = new NormDev(1100,200,600);
        
        weight = (int)getWt.genNorm();
    }
    
    public void setBlock(Block in){
        try{
            weight = in.getWeight();
        }
        catch (NullPointerException e){
            weight = 0;
        }
    }
   

    
    public int getWeight(){
        return weight;
    }
    
    
}
