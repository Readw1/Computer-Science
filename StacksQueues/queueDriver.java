
public class queueDriver
{
    public static void main(String[] args){
        ALQueue one = new ALQueue();
        System.out.println(one.isEmpty());
        one.enQ("hello");
        one.enQ("APCS");
        one.enQ("Advanced programming");
        one.enQ("Z_WJIOJ");
        System.out.println(one.isEmpty());
        System.out.println(one.getSize());
        
        one.printQueue();
        System.out.println("");
        System.out.println(one.deQ());
        System.out.println("");
        one.printQueue();
        System.out.println("");
        
        System.out.println(one.peek());
        System.out.println("");
        one.printQueue();
        System.out.println("");
        
        one.printALStack();
        
        
        
        
    }
}
