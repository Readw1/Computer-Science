public class DNode{
    private Object ob;
    private DNode next;
    private DNode prev;
    
    
    public DNode(Object inOb, DNode inNext, DNode inPrev){
        ob = inOb;
        next = inNext;
        prev = inPrev;
    }
    
    public DNode(Object inOb){
        ob = inOb;
    }
    
    public DNode getNext(){
        return next;
    }
    
    public DNode getPrev(){
        return prev;
    }
    
    public Object getInfo(){
        return ob;
    }
    
    public void setNext(DNode n){
        next = n;
    }
    
    public void setPrev(DNode n){
        prev = n;
    }
}