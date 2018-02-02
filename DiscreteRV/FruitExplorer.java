
public class FruitExplorer
{
    /**
     * Takes num grapefruits, num oranges, num tangerines, and num trials
     * Prints out the weights of the biggest box, the smallest box, and the average
     */
    static void explore(int g, int o, int t, int num){
        double maxWt= 0.0;
        double minWt = Double.MAX_VALUE;
        
        double tot = 0.0;
        double avg = 0.0;
        
        for(int c = 0; c<num; c++){
            
            FruitBox exp = new FruitBox(g,o,t);
            if(exp.getTotalWeight()>maxWt){
                maxWt = exp.getTotalWeight();
            }
            if(exp.getTotalWeight()<minWt || c == 0){
                minWt = exp.getTotalWeight();
            }
            tot+=exp.getTotalWeight();
        }
        avg = 1.0*tot/num;
        
        System.out.println("Max weight: " + maxWt);
        System.out.println("Min weight: " + minWt);
        System.out.println("Avg weight: " + avg);
        
        
    }
}
