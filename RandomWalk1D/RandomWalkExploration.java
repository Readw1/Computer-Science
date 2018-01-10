

public class RandomWalkExploration
{
    
    static int[] times= new int[1001];
    static double[] proportions= new double[1001];
    static int[] returned = new int[501];
    static double[] returnedProp = new double[501];
    
    
    public static void getDistributions(int numWalks){
        
        for(int c = 0; c<numWalks; c++){
            RandomWalk1D test =  new RandomWalk1D();
            times[test.stepsUntilReturn()]++;
        }
        
        for(int c = 0; c<proportions.length; c++){
            proportions[c] = 1.0*times[c]/numWalks;
        }
        
        
        
        System.out.println("Counts");
        int L = 2;
        for(int c = 2; c<times.length; c++){
            if(times[c]!=0){
                System.out.print(c + " Steps: " + times[c] + "| ");
                L++;
            }
            if((L+1)%10 == 0){
                System.out.println("");
                L++;
            }
            
        }
        System.out.println("");
        System.out.println("Proportions");
        int k = 2;
        for(int c = 2; c<proportions.length; c++){
            if(times[c]!=0){
                System.out.print(c + " Prop: " + proportions[c] + "| ");
                k++;
            }
            if((k+1)%10 == 0){
                System.out.println("");
                k++;
            }
        }
        
        double average = 0;
        for(int c = 2; c<times.length; c++){
            average += times[c]*c;
        }
        average /= numWalks;
        System.out.println("");
        System.out.println(average);
    }
    
    /**
     * Number of times it reaches 0 again in a walk with numSteps steps
     */
    public static void getNumTimesReturned(int numWalks, int numSteps){
        for(int c = 0; c<numWalks; c++){
            RandomWalk1D test = new RandomWalk1D();
            int in = test.getNumReturns(numSteps);
            returned[in]++;
            
        }
        
        
        
        
        for(int c = 0; c<returnedProp.length; c++){
            
            returnedProp[c] = 1.0*returned[c]/numWalks;
        }
        
        
        
        
        System.out.println("Number of walks with a given number of returns");
        int L = 0;
        for(int c = 0; c<returned.length; c++){
            if(returned[c]!=0){
                System.out.print(c + " Rets: " + returned[c] + "| ");
                L++;
            }
            if((L+1)%10 == 0){
                System.out.println("");
                L++;
            }
            
        }
        System.out.println("");
        System.out.println("Proportions");
        int k = 0;
        for(int c = 0; c<returnedProp.length; c++){
            if(returnedProp[c]!=0){
                System.out.print(c + " Prop: " + returnedProp[c] + "| ");
                k++;
            }
            if((k+1)%10 == 0){
                System.out.println("");
                k++;
            }
        }
        
        double average = 0;
        for(int c = 0; c<returned.length; c++){
            average += returned[c]*c;
        }
        average /= numWalks;
        System.out.println("");
        System.out.println(average);
        
        
    }
    
}
