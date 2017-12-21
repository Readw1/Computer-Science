import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

public class LinearSystem
{
    Matrix coef;
    Matrix rhs;
    public LinearSystem(int rows, int cols, String A, String B){
        coef = new Matrix(rows, cols, A);
        rhs = new Matrix(rows,1,B);
    }
    
    public LinearSystem(String f, String g){
        coef = new Matrix(f);
        rhs = new Matrix(g);
    }
    
    public String toString(){
        double [][] co = coef.getMatrix().clone();
        double [][] rh = rhs.getMatrix().clone();
        String returned = "";
        int num = 65;
        for(int c = 0; c<co.length; c++){
            num=65;
            for(int i = 0; i<co.length; i++){
                if (i != co.length-1){
                    if(co[c][i+1]<0){
                        returned += Math.abs(co[c][i]);
                        returned += (char)num;
                        num++;
                        returned += " - ";
                    }
                    else{
                        returned += Math.abs(co[c][i]);
                        returned += (char)num;
                        num++;
                        returned += " + ";
                    }
                    
                }
                else{
                    returned += co[c][i];
                    returned += (char)num;
                    num++;
                    returned += " = ";
                }
                
            }
            returned += rh[c][0];
            returned += "\n";
        }
        return returned;
    }
    
    public boolean hasUniqueSolution(){
        boolean hasSolution = true;
        if (coef.calcdeterm(coef)==0){
            hasSolution = false;
        }
        return hasSolution;
    }
    
    public double solveForVariable(int v){
        double D = 0;
        double Dv = 0;
        D = coef.calcdeterm(coef);
        
        double[][] co1 = coef.getMatrix();
        double[][] co = new double[co1.length][co1[0].length];
        
        for(int c = 0; c<co1.length; c++){
            for(int j = 0; j<co1[0].length; j++){
                co[c][j] = co1[c][j];
            }
        }
        
        double[][] r1 = rhs.getMatrix();
        double[][] r = new double[r1.length][r1[0].length];
        
        for(int c = 0; c<r1.length; c++){
            for(int j = 0; j<r1[0].length; j++){
                r[c][j] = r1[c][j];
            }
        }
    
        for(int c = 0; c<co.length; c++){
            co[c][v-1] = r[c][0];
        }
       
        
        Matrix det = new Matrix(co);
        
        Dv = det.calcdeterm(det);
        if(Dv/D==-0.0){
            return 0;
        }
        else{
            return Dv/D;
        }
    }
    
    public double[] getSolutions(){
        double[] solutions = new double[coef.getNumCols()];
        for(int c = 1; c<coef.getNumCols()+1; c++){
            solutions[c-1] = this.solveForVariable(c);
        }
        
        for(int i = 0; i<solutions.length; i++){
            System.out.print(solutions[i] + " ");
        }
        return solutions;
    }
    
    
}
