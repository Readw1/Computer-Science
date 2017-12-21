
public class TNode
{
    private Comparable info;
    private TNode left;
    private TNode right;
    private int size;
    private String a;
    
    
    public TNode(Comparable inFo, TNode inLeft, TNode inRight){
        info = inFo;
        left = inLeft;
        right = inRight;
    }
    
    public TNode(Comparable inFo){
        info = inFo;
    }
    
    public int getSizeFromNode(){
        size=0;
        size++;
        if(left!=null){
            size+=left.getSizeFromNode();
        }
        if(right!=null){
            size+=right.getSizeFromNode();
        }
        return size;
    }
    
    public String getStringFromNode(){
        a="";
        if(left!=null){
            a+=left.getStringFromNode();
        }
        a+=info.toString() + " ";
        if(right!=null){
            a+=right.getStringFromNode();
        }
        return a;
    }
    
    
    
    
    
    public TNode getLeft(){
        return left;
    }
    
    public TNode getRight(){
        return right;
    }
    
    public Comparable getInfo(){
        return info;
    }
    
    public void setLeft(TNode n){
        left = n;
    }
    
    public void setRight(TNode n){
        right = n;
    }
    
    public String toString(){
        return getInfo().toString() + ". Left: " + getLeft().getInfo().toString() + ". Right: " + getRight().getInfo().toString();
    }
    
}
