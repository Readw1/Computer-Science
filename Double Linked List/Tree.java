

public class Tree
{
    TNode root = null;
    String directions = "";
    
    public void addNode(Comparable c){
        TNode temp = root;
        directions = "";
        if(root == null){
            TNode in = new TNode(c, null, null);
            root = in;
        }
        else{
            TNode in = addNode(c,temp);
            
            
        }
    }
    
    
    private TNode addNode(Comparable c, TNode temp){
        
        if(temp == null){
            TNode in = new TNode(c, null, null);
            directions = directions.substring(0,directions.length()-1);
            System.out.println(directions + ": " + in.getInfo());
            return in;
            
        }
        if(c.compareTo(temp.getInfo())<0){
            directions += "Left ";
            temp.setLeft(addNode(c,temp.getLeft()));
            
        }
        else if(c.compareTo(temp.getInfo())>0){
            directions += "Right ";
            temp.setRight(addNode(c,temp.getRight()));
        }
        return temp;
        
    }
    
    public TNode search(Comparable c){
        TNode temp = root;
        if(root == null){
            return null;
        }
        else if(c.compareTo(root.getInfo())==0){
            return root;
        }
        else{
            return search(c, temp);
        }
        
    }
    
    private TNode search(Comparable c, TNode t){
        if(c.compareTo(t.getInfo())==0){
            return t;
        }
        else if((c.compareTo(t.getInfo())>0)&&t.getLeft()!=null){
            return search(c,t.getLeft());
        }
        else if((c.compareTo(t.getInfo())<0)&&t.getRight()!=null){
            return search(c,t.getRight());
        }
        else{
            return null;
        }
    }
    
    public TNode getRoot(){
        return root;
    }
    
    public int getSize(){
        return this.getSize(root);
    }
    
    public int getSizeFromNode(Comparable c){
        TNode n = this.search(c);
        
        int size=1;
        if(n.getLeft()!=null){
            size+=this.getSize(n.getLeft());
        }
        if(n.getRight()!=null){
            size+=this.getSize(n.getRight());
        }
        return size;
    }
    
    public int getSize(TNode n){
        int size=1;
        if(n.getLeft()!=null){
            size+=this.getSize(n.getLeft());
        }
        if(n.getRight()!=null){
            size+=this.getSize(n.getRight());
        }
        return size;
    }
    
    
    public String toString(){
        String returned = root.getStringFromNode();
        returned = returned.substring(0,returned.length()-1);
        return returned;
    }
    
    
    
    
    
        
    }
    
    

