
public class matrixDriver
{
    public static void main(String[]args){
        double[][] h = new double[3][3];
        
        h[0][0]=1;
        h[0][1]=3;
        h[0][2]=5;
        //h[0][3]=4;
        
        h[1][0]=2;
        h[1][1]=-3;
        h[1][2]=7;
       // h[1][3]=8;
        
        h[2][0]=0;
        h[2][1]=3;
        h[2][2]=4;
       // h[2][3]=12;
        /*
        h[3][0]=13;
        h[3][1]=14;
        h[3][2]=15;
        h[3][3]=16;*/
        
        Matrix v = new Matrix(h);
        
        System.out.println(v);
        System.out.println("");
        System.out.println(v.createInverseMatrix());
        
        
    }
}
