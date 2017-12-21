
public class DLL
{
    private DNode head;
    private DNode tail;
    
    
    public void addToFront(Object ob){
        DNode in = new DNode(ob, head, null);
        if(head != null){
            head.setPrev(in);
        }
        head = in;
        if(tail == null){
            tail = in;
        }
    }
    
    public void addToEnd(Object ob){
        DNode in = new DNode(ob, null, tail);
        if(tail != null){
            tail.setNext(in);
        }
        tail = in;
        if(head == null){
            head = in;
        }
    }
    
    public int getNumNodes(){
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
    
    public Object getInfo(int loc){
        DNode temp = head;
        
        for(int c = 0; c<loc-1; c++){
            temp = temp.getNext();
        }
        
        return temp.getNext().getInfo();
        
    }
    
    public Object removeEndNode(){
        DNode temp = tail;
        if(this.getNumNodes()==1){
            tail = null;
            head = null;
        }
        else{
            tail = tail.getPrev();
            tail.setNext(null);
        }
        return temp.getInfo();
    }
    
    public Object removeFirstNode(){
        DNode temp = head;
        if(this.getNumNodes()==1){
            head = null;
            tail = null;
        }
        else{
            head = head.getNext();
            head.setPrev(null);
        }
        
        return temp.getInfo();
    }
    
    public void addToSpotN(Object ob, int n){
        DNode temp = head;
        
        for(int c = 0; c<n-1; c++){
            
            temp = temp.getNext();
        }
        
        DNode in = new DNode(ob, temp.getNext(), temp);
        
        in.getPrev().setNext(in);
        in.getNext().setPrev(in);
    }
    
    public Object removeNode(int n){
        DNode temp = head;
        for(int c = 0; c<n-1; c++){
            
            temp = temp.getNext();
        }
        DNode removed = temp.getNext();
        if(removed.getNext()!=null){
            temp.setNext(removed.getNext());
            removed.getNext().setPrev(temp);
        }
        else{
            temp.setNext(null);
        }
        
        return removed.getInfo();
        
    }
    
    
    
}
