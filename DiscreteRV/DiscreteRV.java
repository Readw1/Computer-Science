import java.util.Scanner;
import java.lang.Math;
public class DiscreteRV
{
    private double[] vals;
    private double[] probs;
    
    public DiscreteRV(double[] v, double[] p){
        vals = new double[v.length];
        probs = new double [p.length];
        for(int c = 0; c<v.length; c++){
            vals[c] = v[c];
            probs[c] = p[c];
        }
        
        
    }
    /**
     * Creates a random variable with values 1 to n, each equally likely (probs = 1/n)
     */
    public DiscreteRV(int n){
        vals = new double[n];
        probs = new double[n];
        
        for(int c = 0; c<vals.length; c++){
            vals[c] = c+1;
            probs[c] = 1.0/n;
        }
        
    }
    /**
     * Asks user for number of values, and each value/probability pair
     */
    public DiscreteRV(){
        Scanner in = new Scanner(System.in);
        System.out.println("How many values?");
        int n = in.nextInt();
        vals = new double[n];
        probs = new double[n];
        
        for(int c = 0; c<vals.length; c++){
            System.out.println("Value " + (c+1) + ": ");
            vals[c] = in.nextDouble();
            
            System.out.println("Prob " + (c+1) + ": ");
            probs[c] = in.nextDouble();
        }
        
        
    }
    
    /**
     * Calculates the mean
     */
    public double calcMean(){
        double tot = 0.0;
        for (int c = 0; c<vals.length; c++){
            tot += vals[c]*probs[c];
        }
        return tot;
    }
    
    /**
     * Calculates the median
     */
    public double calcMedian(){
        double tot = 0.0;
        for (int c = 0; c<vals.length; c++){
            tot += probs[c];
            if(tot>=.5){
                return vals[c];
            }
        }
        System.err.println("Uh oh");
        return -0;
        
    }
    
    /**
     * Calculates the standard Deviation
     */
    public double calcStdDev(){
        double tot = 0.0;
        double mean = this.calcMean();
        for(int c = 0; c<vals.length; c++){
            double current = vals[c]-mean;
            current *= current;
            current *= probs[c];
            tot+=current;
        }
        tot = Math.sqrt(tot);
        return tot;
    }
    
    /**
     * Gives a number in the distribution randomly
     */
    public double getRandomValue(){
        double rand = Math.random();
        double tot = 0.0;
        for (int c = 0; c<vals.length; c++){
            tot += probs[c];
            if(tot>=rand){
                return vals[c];
            }
        }
        return 1.0;
    }
    
    
}
