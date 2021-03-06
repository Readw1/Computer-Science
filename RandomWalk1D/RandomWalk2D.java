import java.lang.Math;
public class RandomWalk2D
{
    private int x;
    private int y;
    
    private double pdown;
    private double pup;
    private double pleft;
    private double pright;
    
    int safeguard;
    /**
     * Constructor
     */
    public RandomWalk2D(){
        x = 0;
        y = 0;
        
        pdown = .25;
        pup = .5;
        pleft = .75;
        pright = 1;
        
        safeguard = 1000000;
    }
    
    public RandomWalk2D(int safe){
        x = 0;
        y = 0;
        
        pdown = .25;
        pup = .5;
        pleft = .75;
        pright = 1;
        
        safeguard = safe;
    }
    
    /**
     * Moves one step up, down, left, or right.
     */
    public int[] move(){
        double inProb = Math.random();
        if (inProb < .25){
            y--;
        }
        else if (inProb < .5){
            y ++;
        }
        else if (inProb <.75){
            x--;
        }
        else {
            x++;
        }
        int[]loc = new int[2];
        loc[0] = x;
        loc[1] = y;
        
        return loc;
    }
    
    /**
     * Moves num steps up, down, left, or right
     */    
    public int[] move(int num){
        int[]loc = new int[2];
        for(int c = 0; c<num;  c++){
            loc = this.move();
        }
        return loc;
    }
    
    /**
     * Moves num steps up, down, left, or right. Prints step and location if pr is true.
     */
    public int[] move(int num, boolean pr){
        int[]loc = new int[2];
        if(pr = false){
            loc = this.move(num);
        }
        else{
            for(int c= 0; c<num; c++){
                loc = this.move();
                System.out.println("Step " + (c+1) + ", (" + x + ", " + y + ")");
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
        move();
        count++;
        while ((oldX!=x)||(oldY!=y)){
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
        
        while((x!=0)||(y!=0)){
            move();
            count++;
            if(count>=safeguard){
                return false;
            }
        }
        return true;
    }
    
    
}
