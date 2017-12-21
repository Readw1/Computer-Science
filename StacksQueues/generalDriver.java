

    
public class generalDriver
{
    public static void main(String[] args){
        generalQ one = new generalQ();
        System.out.println(one.isEmpty());
        one.enQ(4);
        one.enQ("hello");
        one.enQ(3.410);
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
        
        one.printGeneralQueue();
        
        
        
        
    }
}


