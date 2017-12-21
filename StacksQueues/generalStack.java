
import java.util.ArrayList;
public class generalStack
{
   private ArrayList<Object> stack = new ArrayList<Object>();
   
   public void push(Object in){
       stack.add(in);
   }
   
   public Object pop(){
       Object returned = stack.get(stack.size()-1);
       stack.remove(stack.size()-1);
       return returned;
   }
   
   public Object peek(){
       return stack.get(stack.size()-1);
   }
   
   public boolean isEmpty(){
       boolean empty = false;
       
       if(stack.size()!=0){
           empty = true;
       }
       
       return empty;
   }
   
   public int getSize(){
       return stack.size();
   }
   
   public void printStack(){
       for(int c = stack.size()-1; c>=0; c--){
           System.out.println(stack.get(c));
       }
   }
   
   public void printALStack(){
       int count = 1;
       for(int c = stack.size()-1; c>=0; c--){
           System.out.println(count + ": " + stack.get(c));
           count ++;
       }
       
   }
   
   
   
   
}
