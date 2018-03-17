
public class Truck
{
    final private int maxWt = 10000;
    
    private int currentWt;
    private int numBlocks;
    
    
    public Truck(){
        currentWt = 0;
        numBlocks = 0;
    }
    
    public int getCurrentWt(){
        return currentWt;
    }
    
    public int getBlocks(){
        return numBlocks;
    }
    
    
    
    public boolean addBlock(Block in){
        if(currentWt+in.getWeight()<maxWt){
            currentWt += in.getWeight();
            numBlocks++;
            return false;
        }
        return true;
    }
    
    public Block addBlockEfficient(Block in, Block o){
        boolean oHeavy = false;
        if(o.getWeight()>=in.getWeight()){
            oHeavy = true;
        }
        
        if(oHeavy){
            if(currentWt+o.getWeight()<maxWt){
                currentWt += o.getWeight();
                numBlocks++;
                return in;
            }
            else if(currentWt+in.getWeight()<maxWt){
                currentWt += in.getWeight();
                numBlocks++;
                return o;
            }
        }
        else{
            if(currentWt+in.getWeight()<maxWt){
                currentWt += in.getWeight();
                numBlocks++;
                return o;
            }
            else if(currentWt+o.getWeight()<maxWt){
                currentWt += o.getWeight();
                numBlocks++;
                return in;
            }
        }
        
        return null;
    }
}
