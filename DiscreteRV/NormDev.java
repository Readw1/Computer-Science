
public class NormDev
{
    double mu;
    double sigma;
    double r;
    
    public NormDev(double muIn, double sigIn){
        mu = muIn;
        sigma = sigIn;
        r = 10;
    }
    
    public NormDev(double muIn, double sigIn, double rIn){
        mu = muIn;
        sigma = sigIn;
        r = rIn;
    }
    
    public double genNorm(){
        StdNorm norm = new StdNorm(r);
        
        return mu + norm.genStdNorm()*sigma;
    }
}
