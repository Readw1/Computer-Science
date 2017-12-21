
/**
 * Write a description of class pointStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pointStack
{
    private DNode head;
    private DNode tail;
    
    
    
    public void push(Object ob){
        DNode in = new DNode(ob, null, tail);
        if(tail != null){
            tail.setNext(in);
        }
        tail = in;
        if(head == null){
            head = in;
        }
    }
    
    public int getSize(){
        int size = 0;
        
        if(head!=null){
            DNode temp = head;
            while (temp.getNext()!=null){
                size++;
                temp = temp.getNext();
            }
            size++;
        }
        return size;
    }
    
    
    public Object pop(){
        DNode temp = tail;
        if(this.getSize()==1){
            tail = null;
            head = null;
        }
        else{
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return temp.getInfo();
    }
    
    public Object peek(){
        return tail.getInfo();
    }
    
    public void printStack(){
        if(head!=null){
            DNode temp = tail;
            while (temp.getPrev()!=null){
                System.out.println(temp.getInfo().toString());
                temp = temp.getPrev();
                
            }
            System.out.println(temp.getInfo().toString());
            
        }
    }
    
    public String toString(){
        String returned = "";
        if(head!=null){
            DNode temp = tail;
            while (temp.getPrev()!=null){
                returned+=temp.getInfo().toString();
                returned+="\t";
                temp = temp.getPrev();
                
            }
            returned+=temp.getInfo().toString();
            
        }
        return returned;
        
    }
    
    
    
    
}
