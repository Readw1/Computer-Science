import java.util.ArrayList;
public class ALQueue
{
    private ArrayList<String> queue = new ArrayList<String>();
    
    public void enQ(String in){
       queue.add(in);
   }
   
   public String deQ(){
       String returned = queue.get(0);
       queue.remove(0);
       return returned;
   }
   
   public String peek(){
       return queue.get(0);
   }
   
   public boolean isEmpty(){
       boolean empty = false;
       
       if(queue.size()!=0){
           empty = true;
       }
       
       return empty;
   }
   
   public int getSize(){
       return queue.size();
   }
   
   public void printQueue(){
       for(int c = 0; c<queue.size(); c++){
           System.out.println(queue.get(c));
       }
   }
   
   public void printALStack(){
       int count = 1;
       for(int c = 0; c<queue.size(); c++){
           System.out.println(count + ": " + queue.get(c));
           count ++;
       }
       
   }
    
}
