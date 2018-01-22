import java.lang.Math;
public class RandomWalk1D
{
    private int loc;
    private double negProb;
    int safeguard = 1000000;
    /**
     * Constructors
     */
    public RandomWalk1D(){
        loc = 0;
        negProb = .5;
    }
    public RandomWalk1D(double np){
        loc = 0;
        negProb = np;
    }
    public RandomWalk1D(int begin, double np){
        loc = begin;
        negProb = np;
    }
    
    /**
     * Does one move in the walk
     */
    public int move(){
        double inProb = Math.random();
        if (inProb < negProb){
            loc--;
        }
        else{
            loc ++;
        }
        return loc;
    }
    
    /**
     * Does num moves in the walk
     */
    public int move(int num){
        for(int c = 0; c<num;  c++){
            loc = this.move();
        }
        return loc;
    }
    /**
     * Does num moves in the walk, prints out step number and location if pr is true
     */
    public int move(int num, boolean pr){
        int newloc = 0;
        if(pr = false){
            newloc = this.move(num);
        }
        else{
            for(int c= 0; c<num; c++){
                newloc = this.move();
                System.out.println("Step " + (c+1) + ", Loc " + loc);
            }
        }
        return newloc;
    }
    /**
     * Counts the amount of steps it takes for a walk to return to the position it was when it started
     */
    public int stepsUntilReturn(){
        int count = 0;
        int oldLoc = loc;
        move();
        count++;
        while (loc!=oldLoc){
            move();
            count++;
            if(count>=1000){
                break;
            }
        }
        return count;
    }
    /**
     * Counts the number of steps it takes for a walk to reach the location end
     */
    public int stepsUntilReaches(int end){
        int count = 0;
        while (loc != end){
            move();
            count ++;
            if(count>=1000){
                break;
            }
        }
        return count;
    }
    
    /**
     * Gets the number of times the walk returns to its original location in a given number of steps
     */
    public int getNumReturns(int steps){
        int origLoc = loc;
        int numReturns = 0;
        for(int c = 0; c<steps; c++){
            move();
            if(loc == origLoc){
                numReturns ++;
            }
        }
        return numReturns;
    }
    
    
    /**
     * Determines whether the walk returns to 0 within safeguard steps. (true if so, false if not)
     */
    public boolean walkReturns(){
        int count = 1;
        move();
        
        while(loc!=0){
            move();
            count++;
            if(count>=safeguard){
                return false;
            }
        }
        return true;
    }
    
    
}

