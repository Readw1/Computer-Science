import java.util.ArrayList;
public class generalQ
{
   private ArrayList<Object> queue = new ArrayList<Object>();
    
    public void enQ(Object in){
       queue.add(in);
   }
   public Object deQ(){
       Object returned = queue.get(0);
       queue.remove(0);
       return returned;
   }
   
   public Object peek(){
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
   
   public void printGeneralQueue(){
       int count = 1;
       for(int c = 0; c<queue.size(); c++){
           System.out.println(count + ": " + queue.get(c));
           count ++;
       }
       
   }
}
