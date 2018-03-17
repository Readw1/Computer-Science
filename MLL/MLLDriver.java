
public class MLLDriver
{
    public static void main(String[] args){
        MLList d = new MLList();
        
        Info m1 = new Info("b", 1);
        MLNode a = new MLNode(m1);
        d.add(a);
        
        Info m2 = new Info("c", 3);
        MLNode c = new MLNode(m2);
        d.add(c);
        
        
        Info m3 = new Info("a", 2);
        MLNode b = new MLNode(m3);
        d.add(b);
        
        d.print();
        
        
        
    }
}
