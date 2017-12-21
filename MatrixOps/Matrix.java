import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

public class Matrix
{
    private double[ ][ ] m;


    public Matrix(double[][] inM){
        m = new double[inM.length][inM[0].length];
        for(int c =0; c<inM.length; c++){
            for(int i = 0; i<inM[0].length; i++){
                m[c][i] = inM[c][i];
            }
        }
    }
    
    
    /**
     * Default constructor for objects of class Matrix
     * Enter number of rows and columns, all elements set to 0
     */
    public Matrix(int r, int c)
    {
        m=new double[r][c];
        for (int i = 0; i<m.length; i++){
            for (int q = 0; q<m[0].length; q++){
                m[i][q]=0;
            }
        }
    }

    /**
     * Constructor for objects of class Matrix
     * All info obtained from file f
     * Format of f: #rows #cols elements by row, whitespace delimeted
     */
    public Matrix(String f)
    {
        try
        {
            FileReader reader = new FileReader(f);
            Scanner in = new Scanner(reader);
            int numRows=in.nextInt();
            int numCols=in.nextInt();
            m=new double[numRows][numCols];
            for (int r=0;r<numRows;r++)
            {   
                for(int c=0;c<numCols;c++)
                {
                    m[r][c]=in.nextDouble();
                }
            }
        }
        catch(IOException exception)
        {
            System.out.println("Error processing file: " + f);
        }
    }

    /**
    * Matrix constructor from number rows and columns provided
    * and elements given within a string, at least 1 space between elements
    */
    public Matrix(int rows, int cols, String s)
    {
        Scanner input=new Scanner(s);
        m=new double[rows][cols];
        for (int r=0;r<rows;r++)
        {
            for (int c=0;c<cols;c++)
            {
                m[r][c]=input.nextDouble();
            }
        }
    }
    
    /**
     * Copy constructor 
     */
    public Matrix(Matrix neo)
    {
        
        String y = "";
        double[][] n = neo.getMatrix().clone();
        
        for (int i = 0; i<n.length; i++){
            for (int q = 0; q<n[0].length; q++){
                y += n[i][q] + " ";
            }
        }
        
        Matrix returned = new Matrix(neo.getNumRows(), neo.getNumCols(), y);
    }
    
    public int getNumRows(){
        return m.length;
    }
    
    public int getNumCols(){
        return m[0].length;
    }
    
    
    public String toString()
    {
      int count = 1;
      int count2 = 1;
      String returned = "";
        for (int i = 0; i<m.length; i++){
            
            for (int q = 0; q<m[0].length; q++){
             
             
             if (count%m[0].length == 0){
             
                returned += (m[count2-1][count-1]);
                returned += "\n";
                count ++;
              
           
             }
      
             else {
            
                returned += (m[count2-1][count-1]);
                returned += "\t";
                count ++;
            
            
             }
        }
        count = 1;
        count2++;

      }
      return returned;
    }
    
    
    public double[][] getMatrix(){
        return m;
    }
    
    public double calcdeterm(Matrix m){
        double [][] mat = m.getMatrix().clone();
        
        if(mat.length==1 && mat[0].length==1){
            return mat[0][0];
        }
        else if(mat.length==2 && mat[0].length==2){
            return (mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]);
        }
        else{
            double tot = 0.0;
            for(int c = 0; c<mat.length; c++){
                double[][] inMat = new double[mat.length-1][mat[0].length-1];
                for(int i = 1; i<mat.length; i++){
                    for(int j = 0; j!=c; j++){
                        inMat[i-1][j]=mat[i][j];
                    }
                    if(c+1!=mat.length){
                        for(int j = c+1; j<mat.length; j++){
                            inMat[i-1][j-1]=mat[i][j];
                        }
                    }
                }
                Matrix inM = new Matrix(inMat);
                tot+= Math.pow(-1,1+(c+1)) * mat[0][c] * calcdeterm(inM);
            }
            return tot;
        }
        
    }
    
    public boolean isSquare(){
        return (getNumRows()==getNumCols());
    }
    
    public boolean canMultiplyBy(Matrix other){
        return (getNumCols()==other.getNumRows());
    }
    
    
    
    public Matrix multiply(Matrix other){
        double[][] q = new double[getNumRows()][other.getNumCols()];
        double thisCellTot = 0;
        double[][] o = other.getMatrix().clone();
        
        int m1col = 0;
        int m2row = 0;
        
        for(int r = 0; r<getNumRows(); r++){
            for(int c = 0; c<other.getNumCols(); c++){
                m1col = 0;
                m2row = 0;
                while(m1col<getNumCols()){
                    q[r][c] += m[r][m1col]*o[m2row][c];
                    m1col++;
                    m2row++;
                }
            }
        }
        
        Matrix returned = new Matrix(q);
        return returned;
    }
    
    
    
    public Matrix createTranspose(){
        Matrix m;
        double[][] nums = new double[getNumRows()][getNumCols()];
        for(int i = 0; i<getNumRows(); i++){
            for (int c = 0; c<getNumCols(); c++){
                nums[i][c] = getMatrix()[c][i];
            }
        }
        m = new Matrix(nums);
        return m;
    }
    
    public Matrix createSubmatrix(int r, int c){ //omits row r, column c
        Matrix m;
        r--;
        c--;
        double[][] nums = this.getMatrix().clone();
        String inmat="";
        for(int i = 0; i<getNumRows(); i++){
            for (int j = 0; j<getNumCols(); j++){
                if(i!=r&&j!=c){
                    inmat+=nums[i][j];
                    inmat+=" ";
                }
            }
        }
        m = new Matrix(getNumRows()-1,getNumCols()-1,inmat);
        return m;
    }
    
    public Matrix createCofactorMatrix(){
        Matrix m;
        
        String inMat = "";
        for(int r = 1; r<getNumRows()+1; r++){
            for(int c = 1; c<getNumCols()+1; c++){
                Matrix t = new Matrix(this.createSubmatrix(r,c).getMatrix());
                inMat += t.calcdeterm(t)*Math.pow(-1,r+c);
                inMat += " ";
                
            }
            
        }
        m = new Matrix(getNumRows(), getNumCols(), inMat);
        return m;
    }
    
    
    public Matrix createInverseMatrix(){
        double determ = this.calcdeterm(this);
        Matrix m = new Matrix(this.createCofactorMatrix().getMatrix());
        Matrix n = new Matrix(m.createTranspose().getMatrix());
        Matrix o = new Matrix(n.multiply(1/determ).getMatrix());
        return o;
    }
    
    public Matrix multiply(double d){
        double[][] num = new double[getNumRows()][getNumCols()];
        for(int i = 0; i<getNumRows(); i++){
            for (int c = 0; c<getNumCols(); c++){
                num[i][c] = getMatrix()[i][c]*d;
            }
        }
        Matrix m = new Matrix(num);
        return (m);
    }
    
    
    
    
    
    
    
    
   
}