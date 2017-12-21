
/**
 * Write a description of class pointQ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pointQ
{
    private DNode head;
    private DNode tail;
    
    
    
    
    public void enQ(Object ob){
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
    
    public Object peek(){
        return head.getInfo();
    }
    
    
    
    
    public Object deQ(){
        DNode temp = head;
        if(this.getSize()==1){
            head = null;
            tail = null;
        }
        else{
            head = head.getNext();
            head.setPrev(null);
        }
        
        return temp.getInfo();
    }
    
    public void printQ(){
        
        
        if(head!=null){
            DNode temp = head;
            while (temp.getNext()!=null){
                System.out.println(temp.getInfo().toString());
                temp = temp.getNext();
                
            }
            System.out.println(temp.getInfo().toString());
            
        }
       
    }
    
    public String toString(){
        String returned = "";
        
        if(head!=null){
            DNode temp = head;
            while (temp.getNext()!=null){
                returned+=temp.getInfo().toString();
                returned+="\t";
                temp = temp.getNext();
                
            }
            returned+=temp.getInfo().toString();
            
        }
        return returned;
       
    }
    
    
    
    
    
}
