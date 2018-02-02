

public class NormalFruit
{
    final private double GSig = .9;
    final private double GLim = 3*GSig;
    final private double GMu = 8.7;
    
    
    final private double OSig = .3;
    final private double OLim = 3*OSig;
    final private double OMu = 4.6;
    
    
    final private double TSig = .2;
    final private double TLim = 3*TSig;
    final private double TMu = 3.1;
    
    public String toString(){
        return "Grapefruits: Mean " + GMu + ", Std Dev " + GSig + ". Oranges: Mean " + OMu + ", Std Dev " + OSig  + ". Tangerines: Mean " + TMu + ", Std Dev " + TSig + ".";
    }
    
    /**
     * Gets a normally generated weight for a grapefruit
     */
    public double getGWt(){
        NormDev r = new NormDev(GMu, GSig, GLim);
        return r.genNorm();
    }
    
    /**
     * Gets a normally generated weight for an orange
     */
    public double getOWt(){
        NormDev r = new NormDev(OMu, OSig, OLim);
        return r.genNorm();
    }
    
    /**
     * Gets a normally generated weight for a tangerine
     */    
    public double getTWt(){
        NormDev r = new NormDev(TMu, TSig, TLim);
        return r.genNorm();
    }
    
    
    
    
}
