/**
 * A class to obtain and calculate some information about a 2-dimensional Polygon
 * Polygon is stored as a list of Points, a class included in this project
 */
import java.util.ArrayList;   import java.util.Scanner;   import java.lang.Math;   import java.util.Collections;
public class Polygon
{
    private ArrayList <Point> verts;   //Point class created for this project; NOT Java’s Point class

    /** 
     * Obtains a Polygon from an ArrayList of Points
     */
    public Polygon (ArrayList <Point> v)
    {
        verts = new ArrayList<Point>();
        for(int c = 0; c<v.size(); c++){
            verts.add(v.get(c));
        }
    }
    
    /**
     * Obtains a Polygon from an array of doubles
     * Array contains x0, y0, x1,y1,x2,y2,...,xn-1,yn-1, xi = ith x-coordinate, yi similar
     */
    public Polygon (double [] v)
    {
        verts = new ArrayList<Point>();
        for(int c = 0; c<v.length-1; c++){
            Point in = new Point(v[c], v[c+1]);
            
            verts.add(in);
        }
    }

    /**
    * Constructor, user enters number of points, then enters each point coordinate by coordinate using Scanner
    */
    public Polygon (int numpoints)
    {
        verts = new ArrayList<Point>();
        Point in;
        double inX;
        double inY;
        Scanner pt = new Scanner(System.in);
        for (int c = 0; c<numpoints; c++){
            System.out.println("Point " + c + " X coordinate: ");
            inX = pt.nextDouble();
            
            System.out.println("Point " + c + " Y coordinate: ");
            inY = pt.nextDouble();
            
            in = new Point(inX,inY);
            
            verts.add(in);
            
            
        }
    }
    
    public Polygon ()
    {
        verts = new ArrayList<Point>();
        
        Point q = new Point(0,0);
        verts.add(q);
        
        Point p = new Point(-1,4);
        verts.add(p);
        
        Point w = new Point(2,6);
        verts.add(w);
        
        Point e = new Point(7,4);
        verts.add(e);
        
        Point r = new Point(8,0);
        verts.add(r);
        
        Point t = new Point(3,-1);
        verts.add(t);
        
        
    }

    /**
     * Returns the perimeter of the given Polygon.
     */
    public double calcPerim() {
        double perim = 0.0;
        
        for (int c = 0; c<verts.size(); c++){
            if(c==verts.size()-1){
                perim += verts.get(c).calcDistance(verts.get(0));
            }
            else{
                perim += verts.get(c).calcDistance(verts.get(c+1));
            }
        }
        return perim;
    }

    

    /** 
     * prints the indices of Points in this Polygon which represent the longest edge, returns that distance
    */
    public double findLongestEdge()
    {
        double longest = 0.0;
        
        double x1In = 0.0;
        double y1In = 0.0;
        
        double x2In = 0.0;
        double y2In = 0.0;
        
        for (int c = 0; c<verts.size(); c++){
            if(c==verts.size()-1){
                if (verts.get(c).calcDistance(verts.get(0))>longest){
                    longest = verts.get(c).calcDistance(verts.get(0));
                    
                    x1In = verts.get(c).getX();
                    y1In = verts.get(c).getY();
                    
                    x2In = verts.get(0).getX();
                    y2In = verts.get(0).getY();
                    
                }
            }
            else{
                if (verts.get(c).calcDistance(verts.get(c+1))>longest){
                    longest = verts.get(c).calcDistance(verts.get(c+1));
                    
                    x1In = verts.get(c).getX();
                    y1In = verts.get(c).getY();
                    
                    x2In = verts.get(c+1).getX();
                    y2In = verts.get(c+1).getY();
                }
            }
        }
        
        Point one = new Point(x1In, y1In);
        Point two = new Point(x2In, y2In);
        System.out.println(one.toString() + ", " + two.toString());
        return longest;
    }

    /**
    * returns String containing all vertices; i.e, (3.0, 1.0) (5.2, 3.7) …”
    */
    public String toString( )   
    {
       String stringed = "";
       for (int c = 0; c<verts.size(); c++){
           stringed += verts.get(c).toString();
           stringed += " ";
       }
       return stringed;
    }
 
    /**
    * prints the indices of Points in this Polygon which are the largest distance apart, returns that distance
    */
    public double findLongestDiagonal()
    {
      double longest = 0.0;
        
      double x1In = 0.0;
      double y1In = 0.0;
      
      double x2In = 0.0;
      double y2In = 0.0;
        
      for (int c = 0; c<verts.size(); c++){
          for(int j = 0; j<verts.size(); j++){
              
              if (verts.get(c).calcDistance(verts.get(j))>longest){
                  longest = verts.get(c).calcDistance(verts.get(j));                    
                  x1In = verts.get(c).getX();
                  y1In = verts.get(c).getY();
                    
                  x2In = verts.get(j).getX();
                  y2In = verts.get(j).getY();
                  
              }
            
              
          }
      }
      
      Point one = new Point(x1In, y1In);
      Point two = new Point(x2In, y2In);
      System.out.println(one.toString() + ", " + two.toString());
      return longest;
    }

    /**
    * Returns the area of the given Polygon—calculated recursively
     * Pre: Polygon is convex
    * Pre: Coordinates are in clockwise order
    */
    public double calcArea() {
      ArrayList<Point> p = new ArrayList<Point>();
      for(int i = 0; i<verts.size(); i++){
          p.add(verts.get(i));
      }
      
      ArrayList<Point> triVerts = new ArrayList<Point>();
      triVerts.add(p.get(0));
      triVerts.add(p.get(1));
      triVerts.add(p.get(2));
      
      if(p.size() <= 3){
          double part1 = triVerts.get(0).getX()*(triVerts.get(1).getY()-triVerts.get(2).getY());
          double part2 = triVerts.get(1).getX()*(triVerts.get(2).getY()-triVerts.get(0).getY());
          double part3 = triVerts.get(2).getX()*(triVerts.get(0).getY()-triVerts.get(1).getY());
          return .5*Math.abs(part1 + part2 + part3);
      }
      else{
          p.remove(1);
          Polygon l = new Polygon(p);
          
          double part1 = triVerts.get(0).getX()*(triVerts.get(1).getY()-triVerts.get(2).getY());
          double part2 = triVerts.get(1).getX()*(triVerts.get(2).getY()-triVerts.get(0).getY());
          double part3 = triVerts.get(2).getX()*(triVerts.get(0).getY()-triVerts.get(1).getY());
           
          return l.calcArea() + .5*Math.abs(part1 + part2 + part3);
      }
      
      
    }
    public void putPointsInOrder()
    {
        ArrayList<Point> p = new ArrayList<Point>();
        Point bigX = new Point(0.0,0.0);
        for(int i = 0; i<verts.size(); i++){
            p.add(verts.get(i));
        }
        //gets furthest right point
        for(int c = 0; c<p.size(); c++){
            if(p.get(c).getX()>bigX.getX()){
                bigX=p.get(c);
            }
        }
        
        //finds the closest point to that point
        //if the y value is bigger, use that point as the furthest right
        //else 
        
        for(int j = 0; j<p.size(); j++){
            for(int k = 0; k<p.size(); k++){
                if(closestX(bigX,p).getY()>bigX.getY()){
                }
            }
        }
        
        
        
    }

     /**
     * Changes order of verts to place them in counter-clockwise order *BONUS Assignment*
     */
    public Point closestX(Point l, ArrayList<Point>p){
        int thispoint = 0;
        Point bigX = new Point(0.0,0.0);
        
        for(int j = 0; j<p.size(); j++){
            if (p.get(j).getX()==l.getX() && p.get(j).getY()==l.getY()){
                thispoint = j;
                break;
            }
        }
        p.remove(thispoint);
        
        for(int c = 0; c<p.size(); c++){
            if(p.get(c).getX()>bigX.getX()){
                bigX=p.get(c);
            }
        }
        
        return bigX;
    }
    
}
