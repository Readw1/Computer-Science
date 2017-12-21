import java.util.ArrayList;
public class genPriQ
{
    private ArrayList<Package> q = new ArrayList<Package>();
    
    public void enQ(Package p)
    {
        if ((q.size()==0)||p.getPriority()==1){
            q.add(p);
        }
        
        else {
            for(int c = 0; c < q.size(); c++){
                if(q.size()==1&&(q.get(0).getPriority()>p.getPriority())){
                    q.add(p);
                    break;
                }
                else if((q.get(c).getPriority()<p.getPriority())){
                    q.add(c,p);
                    break;
                }
                else if (c==q.size()-1){
                    q.add(p);
                    break;
                }
            }
        }
        
    }
    
    
    
    public int[] getPriCounts(){
        int[] counts = new int[10];
        for(int c = 0; c<q.size(); c++){
            counts[q.get(c).getPriority()]++;
        }
        for(int c = 0; c<10; c++){
            System.out.println(counts[c]);
        }
        return counts;
    }
    
    public Package deQ(){
       Package returned = new Package(q.get(0).getCode(),q.get(0).getTime(), q.get(0).getPriority());
       q.remove(0);
       return returned;
    }
    
    public Package peek(){
       return q.get(0);
    }
   
    public boolean isEmpty(){
       boolean empty = true;
       
       if(q.size()!=0){
           empty = false;
       }
       
       return empty;
    }
   
    public int getSize(){
       return q.size();
    }
   
    public void printQueue(){
       for(int c = 0; c<q.size(); c++){
           System.out.println(q.get(c));
       }
    }
   
    public void printPriQ(){
       for(int c = 0; c<q.size(); c++){
           System.out.println(q.get(c).toString());
       }
       
    }
    
}
