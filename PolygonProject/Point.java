import java.lang.Math;
/**
 * A class to store two coordinates of a point, both doubles.
 */
public class Point
{
    private double x; private double y;
    
    /**
     * Constructor for objects of class Point
     */
    public Point(double xIn, double yIn)
    {
        x=xIn;
        y=yIn;
    }
    
    public Point(Point p){
        x = p.getX();
        y = p.getY();
    }
    
    /**
     * returns the x coordinate of the point
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * returns the y coordinate of the point
     */
    public double getY()
    {
        return y;
    }
    
    /**
     * Returns distance between this point and point p.  
     */
    public double calcDistance(Point p) {
        double distance = 0.0;
        
        distance = Math.sqrt(Math.pow((p.getX()-this.getX()),2)+Math.pow((p.getY()-this.getY()),2));
        
        return distance;
    }

     /**
     * returns a String representation of the point, i.e., "(x,y)"
     */
    public String toString()
    {
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}
