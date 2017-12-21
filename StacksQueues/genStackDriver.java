
public class genStackDriver
{
    public static void main(String[] args){
        generalStack one = new generalStack();
        System.out.println(one.isEmpty());
        one.push("hello");
        one.push("APCS");
        one.push("Advanced programming");
        one.push("Z_WJIOJ");
        System.out.println(one.isEmpty());
        System.out.println(one.getSize());
        
        one.printStack();
        System.out.println("");
        System.out.println(one.pop());
        System.out.println("");
        one.printStack();
        System.out.println("");
        
        System.out.println(one.peek());
        System.out.println("");
        one.printStack();
        System.out.println("");
        
        one.printALStack();
        
        
        
        
    }
}
