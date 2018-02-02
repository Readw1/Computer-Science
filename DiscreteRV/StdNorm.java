import java.lang.Math;
public class StdNorm
{
    double r;

    /**
     * Constructors for objects of class StdNorm
     */
    public StdNorm(){
        r = 10.0;
    }
    
    public StdNorm(double rIn){
        r = rIn;
    }
    
    public double f(double x){
        return (1.0/Math.sqrt(2*Math.PI))*Math.pow(Math.E, -1.0*Math.pow(x,2)/2);
    }
    
    public double genStdNorm(){
        
        double v = (Math.random()*(2*r))-r;
        double fv = f(v);
        double h = Math.random()*.4;
        
        if(h<fv){
            return v;
        }
        else{
            return genStdNorm();
        }
        
        
        
    }
    
    public double zigg(){
        double v = (Math.random()*(2*r))-r;
        double fv = (1.0/Math.sqrt(2*Math.PI))*Math.pow(Math.E, -1.0*Math.pow(v,2)/2);
        double h;
        if(v>=-r&&v<-r/2.0){
            double max = f(-r/2.0)+.1;
            h = Math.random()*max;
        }
        else if(v>=-r/2.0&&v<0){
            double max = f(0)+.1;
            h = Math.random()*max;
        }
        else if(v>=0&&v<r/2.0){
            double max = f(r/2.0)+.1;
            h = Math.random()*max;
        }
        else if(v>=r/2.0&&v<=r){
            double max = f(r)+.1;
            h = Math.random()*max;
        }
        else{
            h = 0.0;
            System.err.println("zigg error");
        }
        
        System.out.println(v + ", " + fv + ", " + h);
        if(h<fv){
            return v;
        }
        else{
            return zigg();
        }
        
    }
    
   
    }
    
    

    

