import java.lang.Math;
public class RandomWalk3D
{
    private int x;
    private int y;
    private int z;
    
    private double pdown;
    private double pup;
    private double pleft;
    private double pright;
    private double pin;
    private double pout;
    
    int safeguard;
    /**
     * Constructor
     */
    public RandomWalk3D(){
        x = 0;
        y = 0;
        z = 0;
        
        pdown = 1.0/6;
        pup = 2.0/6;
        pleft = 3.0/6;
        pright = 4.0/6;
        pin = 5.0/6;
        pout = 6.0/6;
        
        safeguard = 1000000;
        
    }
    
    public RandomWalk3D(int safe){
        x = 0;
        y = 0;
        z = 0;
        
        pdown = 1.0/6;
        pup = 2.0/6;
        pleft = 3.0/6;
        pright = 4.0/6;
        pin = 5.0/6;
        pout = 6.0/6;
        
        safeguard = safe;
        
    }
    
    /**
     * Moves 1 step up, down, left, right, in, or out.
     */ 
    public int[] move(){
        double inProb = Math.random();
        if (inProb < pdown){
            y--;
        }
        else if (inProb < pup){
            y ++;
        }
        else if (inProb < pleft){
            x--;
        }
        else if (inProb<pright){
            x++;
        }
        else if(inProb<pin){
            z--;
        }
        else if (inProb<pout){
            z++;
        }
        else{
            System.err.println("Incorrect probability");
        }
        int[]loc = new int[3];
        loc[0] = x;
        loc[1] = y;
        loc[2] = z;
        
        return loc;
    }
    
    /**
     * Moves num steps up, down, left, right, in, or out.
     */ 
    public int[] move(int num){
        int[]loc = new int[3];
        for(int c = 0; c<num;  c++){
            loc = this.move();
        }
        return loc;
    }
    
    /**
     * Moves num steps up, down, left, right, in, or out. Prints out locations if pr is true.
     */ 
    public int[] move(int num, boolean pr){
        int[]loc = new int[3];
        if(pr = false){
            loc = this.move(num);
        }
        else{
            for(int c= 0; c<num; c++){
                loc = this.move();
                System.out.println("Step " + (c+1) + ", (" + x + ", " + y + ", " + z + ")");
            }
            
        }
        return loc;
    }
    
    /**
     * Counts the amount of steps it takes for a walk to return to the position it was when it started
     */
    public int stepsUntilReturn(){
        int count = 0;
        int oldX = x;
        int oldY = y;
        int oldZ = z;
        move();
        count++;
        while ((oldX!=x)||(oldY!=y)||(oldZ!=z)){
            move();
            count++;
            if(count>=safeguard){
                break;
            }
        }
        return count;
    }
    
    /**
     * Determines whether the walk returns to 0 within safeguard steps. (true if so, false if not)
     */
    public boolean walkReturns(){
        int count = 1;
        move();
        
        while((x!=0)||(y!=0)||(z!=0)){
            move();
            count++;
            if(count>=safeguard){
                return false;
            }
        }
        return true;
    }
    
    
}
