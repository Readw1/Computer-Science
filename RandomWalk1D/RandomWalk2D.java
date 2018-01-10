import java.lang.Math;
public class RandomWalk2D
{
    private int x;
    private int y;
    
    private double pdown;
    private double pup;
    private double pleft;
    private double pright;
    
    public RandomWalk2D(){
        x = 0;
        y = 0;
        
        pdown = .25;
        pup = .5;
        pleft = .75;
        pright = 1;
        
    }
    
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
    
    public int[] move(int num){
        int[]loc = new int[2];
        for(int c = 0; c<num;  c++){
            loc = this.move();
        }
        return loc;
    }
    
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
}
