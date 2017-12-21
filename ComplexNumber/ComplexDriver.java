public class ComplexDriver{
    public static void main(String[] args){
        ComplexNumber blank = new ComplexNumber();
        System.out.println(blank);
        
        ComplexNumber onlyRe = new ComplexNumber(4.2);
        System.out.println(onlyRe);
        
        ComplexNumber one = new ComplexNumber(3,2);
        ComplexNumber two = new ComplexNumber(4,-3);
        
        ComplexNumber copy = new ComplexNumber(one);
        System.out.println(copy);
        
        System.out.println("One modulus: " + one.modulus());
        System.out.println("One conjugate: " +one.conjugate());
        System.out.println("One + two: " + one.add(two));
        System.out.println("One - two: " + one.subtract(two));
        System.out.println("One * 3: " + one.mult(3.0));
        System.out.println("One * two: " + one.mult(two));
        
        System.out.println("");
        System.out.println("One modulus squared: " + one.modulus()*(one.modulus()));
        System.out.println("One * one conjugate: " + one.mult(one.conjugate()));
        System.out.println("");
        
        System.out.println("One/two: "+ one.divide(two));
        
        System.out.println("One^-5.5: " + one.toPower(-5.5));
        System.out.println("One angle: " + one.getAngle());
        System.out.println("ModAngletoComplex(5,.23): " + one.modAngleToComplex(5,.23));
        System.out.print("QuadSoln(1x^2+4x+5): ");
        one.printQuadSoln(1.0,4,5);
    }
}