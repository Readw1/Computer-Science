

public class LinearDriver
{
    public static void main(String[]args){
        
        String coef = "1 3 5 2 -3 7 0 3 4";
        String rhs = "11 -5 9";
        
        
       
        LinearSystem q = new LinearSystem(3,3,coef,rhs);
        
        
        System.out.println(q.toString());
        //System.out.println(q.hasUniqueSolution());
        //System.out.println(q.solveForVariable(1));
        
        System.out.println(q.solveForVariable(2));
        
        System.out.println(q.solveForVariable(3));
        
        q.getSolutions();
        
        
    }
}
