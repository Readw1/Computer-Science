
public class ALPriQDriver
{
    public static void main(String[] args){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        ALPriQ one = new ALPriQ();
        System.out.println(one.isEmpty());
        one.enQ("hello",9);
        one.enQ("APCS",4);
        one.enQ("asdfghjk",2);
        one.enQ("Advanced programming",5);
        one.enQ("Z_WJIOJ",2);
        one.enQ("ZA WARUDO", 9);
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
        
        one.printPriQ();
        
        one.getPriCounts();
        
        
        
        
        
    }
}
