

public class DLLDriver
{
   
    public static void main(String[] args){
        DLL d = new DLL();
        d.addToEnd("0");
        
        d.addToEnd("1");
        d.addToEnd("2");
        d.addToEnd("3");
        d.addToEnd("4");
        
        d.removeNode(4);
        System.out.println(d.getInfo(3));
    }
}
