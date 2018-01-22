

public class RandomWalkExploration
{
    
    static int[] times= new int[1001];
    static double[] proportions= new double[1001];
    static int[] returned = new int[501];
    static double[] returnedProp = new double[501];
    
    /**
     * The array "times" stores in each slot the amount of walks that took that many of steps to return.
     * For instance, the amount of walks in numWalks that took 4 steps to return is stored in times[4].
     * The array "proportions" stores these proportions compared to the total number of walks.
     */
    public static void getDistributions(int numWalks, double negProb){
        for(int c = 0; c<times.length; c++){
            times[c] = 0;
            proportions[c] = 0;
        }
        
        for(int c = 0; c<numWalks; c++){
            RandomWalk1D test =  new RandomWalk1D(negProb);
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
     * The array "returned" stores in each slot the amount of walks that reached 0 that many times.
     * For instance, the amount of walks in numWalks that took reached 0 four times is stored in returned[4].
     * The array "returnedProp" stores these proportions compared to the total number of walks.
     */
    public static void getNumTimesReturned(int numWalks, int numSteps, double negProb){
        for(int c = 0; c<returned.length; c++){
            returned[c] = 0;
            returnedProp[c] = 0;
        }
        for(int c = 0; c<numWalks; c++){
            RandomWalk1D test = new RandomWalk1D(negProb);
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
    
    public static double simReturnLikelihood1D(){
        int[] ret = new int[2];
        
        for(int c = 0; c<1000000; c++){
            RandomWalk1D test = new RandomWalk1D();
            if(test.walkReturns()){
                ret[0]++;
            }
            else{
                ret[1]++;
            }
            System.out.println(c);
        }
        
        
        
        return ret[0]/1000000.0;
    }
    public static double simReturnLikelihood2D(){
        int[] ret = new int[2];
        
        
        for(int c = 0; c<100000; c++){
            RandomWalk2D test = new RandomWalk2D();
            if(test.walkReturns()){
                ret[0]++;
            }
            else{
                ret[1]++;
            }
            System.out.println(c);
        }
        
        
        
        return ret[0]/1000000.0;
    }
    public static double simReturnLikelihood3D(){
        int[] ret = new int[2];
        
        for(int c = 0; c<10000; c++){
            RandomWalk3D test = new RandomWalk3D();
            if(test.walkReturns()){
                ret[0]++;
            }
            else{
                ret[1]++;
            }
            
            System.out.println(c);
        }
        
        
        
        return ret[0]/1000000.0;
    }
    public static void main(String[] args){
        //System.out.println(simReturnLikelihood1D());
        System.out.println(simReturnLikelihood2D());
        //System.out.println(simReturnLikelihood3D());
        
    }
    
    /*
    public static void main(String[] args){
        getDistributions(1000000, .499);
        getNumTimesReturned(1000000, 1000, .499);
        System.out.println("******");
        System.out.println("");
        
        getDistributions(1000000, .49);
        getNumTimesReturned(1000000, 1000, .49);
        System.out.println("******");
        System.out.println("");
        
        getDistributions(1000000, .48);
        getNumTimesReturned(1000000, 1000, .48);
        System.out.println("******");
        System.out.println("");
        
        getDistributions(1000000, .45);
        getNumTimesReturned(1000000, 1000, .45);
        System.out.println("******");
        System.out.println("");
        
        getDistributions(1000000, .42);
        getNumTimesReturned(1000000, 1000, .42);
        System.out.println("******");
        System.out.println("");
        
        getDistributions(1000000, .40);
        getNumTimesReturned(1000000, 1000, .40);
        System.out.println("******");
        System.out.println("");
    }*/
    
    
    
    

    
}
