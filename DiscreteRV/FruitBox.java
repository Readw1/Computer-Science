

public class FruitBox
{
    private int numG; private int numO; private int numT;
    private double[] gs; private double [ ] os; private double [ ] ts;
    
    /**
     * Takes num grapefruits, num oranges, and num tangerines
     * Creates those numbers of normally distributed weights
     */    
    public FruitBox(int inG, int inO, int inT){
        numG = inG;
        numO = inO;
        numT = inT;
        gs = new double[numG];
        os = new double[numO];
        ts = new double[numT];
        
        NormalFruit n = new NormalFruit();
        for(int c = 0; c<numG; c++){
            gs[c] = n.getGWt();
        }
        
        for(int c = 0; c<numO; c++){
            os[c] = n.getOWt();
        }
        
        for(int c = 0; c<numT; c++){
            ts[c] = n.getTWt();
        }
    }
    
    
    public String toString(){
        return numG + " Grapefruits, " + numO + " Oranges, " + numT + " Tangerines.";
    }
    
    
    /**
     * Shortens a double to the tenths place (rounds up if the hundreths place number >=5)
     */    
    private double truncate(double in){
        String t = in+"";
        String[] num = t.split("\\.");
        String wholes = t.substring(0,num[0].length());
        wholes+=".";
        
        
        int decimal = Integer.parseInt(num[1].charAt(0)+"");
        
        String round = num[1].charAt(1)+"";
        if (Double.parseDouble(round)>=5){
            decimal +=1;
        }
        wholes+=decimal+"";
        
        
        double returned = Double.parseDouble(wholes);
        
        
        return returned;
    }
    
    /**
     * Prints out the weights of each fruit stored in the arrays
     */
    public String getListings(){
        String returned = "";
        returned += "Grapefruit: ";
        
        for(int c = 0; c < numG; c++){
            returned += truncate(gs[c]) + " ";
        }
        
        returned += "Oranges: ";
        
        for(int c = 0; c < numO; c++){
            returned += truncate(os[c]) + " ";
        }
        
        returned += "Tangerines: ";
        
        for(int c = 0; c < numT; c++){
            returned += truncate(ts[c]) + " ";
        }
        System.out.println(returned);
        return returned;
    }
    
    /**
     * Gets the total weight of this box
     */
    public double getTotalWeight(){
        double tot = 0;
        
        for(int c = 0; c < numG; c++){
            tot += gs[c];
        }
        for(int c = 0; c < numO; c++){
            tot += os[c];
        }
        for(int c = 0; c < numT; c++){
            tot += ts[c];
        }
        
        tot = truncate(tot);
        
        return tot;
    }
    
    
   
    /**
     * Gets the average weight of a fruit in this box
     */
    public double getAvgWeight(){
        double tot = 0;
        
        for(int c = 0; c < numG; c++){
            tot += gs[c];
        }
        for(int c = 0; c < numO; c++){
            tot += os[c];
        }
        for(int c = 0; c < numT; c++){
            tot += ts[c];
        }
        tot/=(numG+numO+numT);
        tot = truncate(tot);
        
        return tot;
    }
    
    /**
     * Gets the largest fruit in the box
     */
    public double getMaxWeight(){
        double big = 0.0;
        for(int c = 0; c < numG; c++){
            if(gs[c]>big){
                big = gs[c];
            }
        }
        
        for(int c = 0; c < numO; c++){
            if(os[c]>big){
                big = os[c];
            }
        }
        
        for(int c = 0; c < numT; c++){
            if(ts[c]>big){
                big = ts[c];
            }
        }
        return truncate(big);
    }
    
    
    /**
     * Gets the smallest fruit in the box
     */
    public double getMinWeight(){
        double small = 999999.0;
        for(int c = 0; c < numG; c++){
            if(gs[c]<small){
                small = gs[c];
            }
        }
        
        for(int c = 0; c < numO; c++){
            if(os[c]<small){
                small = os[c];
            }
        }
        
        for(int c = 0; c < numT; c++){
            if(ts[c]<small){
                small = ts[c];
            }
        }
        return truncate(small);
    }
    
}
