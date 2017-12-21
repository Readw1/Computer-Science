import java.lang.Math;
public class ComplexNumber
{
    private double re;
    private double im;
    
    public ComplexNumber(){
        re = 0.0;
        im = 0.0;
    }
    
    public ComplexNumber(double a, double b){
        re = a;
        im = b;
    }
    
    public ComplexNumber(double a){
        re = a;
    }
    
    public ComplexNumber(ComplexNumber c){
        re = c.getRe();
        im = c.getIm();
    }
    
    public double getRe(){
        return re;
    }
    
    public double getIm(){
        return im;
    }
    
    public String toString(){
        String returned;
        if (im>0){
            returned = re + " + " + im + "i";
             
        }
        else if(im==-0.0){
            returned = re + " + " + 0.0 + "i";
        }
        else{
            returned = re + " - " + Math.abs(im) + "i";
        }
        return returned;
    }
    
    public double modulus(){
        double square = re*re + im*im;
        return Math.sqrt(square);
    }
    
    public ComplexNumber conjugate(){
        double inim = im*-1;
        ComplexNumber returned = new ComplexNumber(re, inim);
        return returned;
    }
    
    public ComplexNumber add(double c){
        double reIn = re+c;
        ComplexNumber returned = new ComplexNumber(reIn);
        return returned;
    }
    
    public ComplexNumber add(ComplexNumber other){
        double reIn = re+other.getRe();
        double imIn = im+other.getIm();
        ComplexNumber returned = new ComplexNumber(reIn, imIn);
        return returned;
    }
    
    public ComplexNumber subtract(double c){
        double reIn = re-c;
        ComplexNumber returned = new ComplexNumber(reIn);
        return returned;
    }
    
    public ComplexNumber subtract(ComplexNumber other){
        double reIn = re-other.getRe();
        double imIn = im-other.getIm();
        ComplexNumber returned = new ComplexNumber(reIn, imIn);
        return returned;
    }
    
    public ComplexNumber mult(double m){
        double re1 = re*m;
        double im1 = im*m;
        ComplexNumber returned = new ComplexNumber(re1, im1);
        return returned;
    }
    
    public ComplexNumber mult(ComplexNumber other){
        double re1 = re*other.getRe()-im*other.getIm();
        double im1 = re*other.getIm()+im*other.getRe();
        ComplexNumber returned = new ComplexNumber(re1, im1);
        return returned;
    }
    
    public ComplexNumber divide(double d){
        double re1 = re/d;
        double im1 = im/d;
        ComplexNumber returned = new ComplexNumber(re1, im1);
        return returned;
    }
    
    public ComplexNumber divide(ComplexNumber c){
        ComplexNumber top = new ComplexNumber(this.mult(c.conjugate()));
        double bottom = c.mult(c.conjugate()).getRe();
        ComplexNumber returned = top.divide(bottom);
        return returned;
    }
    
    public ComplexNumber toPower(int n){
            double theta = Math.atan(im/re);
            double r = this.modulus();
            
            double inRe = Math.pow(r,n)*Math.cos(n*theta);
            double inIm = Math.pow(r,n)*Math.sin(n*theta);
            ComplexNumber returned = new ComplexNumber(inRe,inIm);
            
            return returned;
    }
    
    public double getAngle(){
        return Math.atan2(im,re);
    }
    
    public ComplexNumber modAngleToComplex(double m, double a){
        double inRe = m*Math.cos(a);
        double inIm = m*Math.sin(a);
        ComplexNumber returned = new ComplexNumber(inRe, inIm);
        return returned;
    }
    
    public ComplexNumber toPower(double n){
            double theta = Math.atan(im/re);
            double r = this.modulus();
            
            double inRe = Math.pow(r,n)*Math.cos(n*theta);
            double inIm = Math.pow(r,n)*Math.sin(n*theta);
            ComplexNumber returned = new ComplexNumber(inRe,inIm);
            
            return returned;
    }
    
    public void printQuadSoln(double a, double b, double c){
        if (a==0){
            System.out.println("Not a quadratic");
        }
        else{
            ComplexNumber z1 = new ComplexNumber(-b, Math.sqrt(Math.abs((b*b)-(4*a*c))));
            ComplexNumber z2 = new ComplexNumber(-b, -1*Math.sqrt(Math.abs((b*b)-(4*a*c))));
            ComplexNumber zero1 = new ComplexNumber(z1.divide(2*a));
            ComplexNumber zero2 = new ComplexNumber(z2.divide(2*a));
            System.out.println(zero1 + ", " + zero2);
        }
    }
    
    
}
