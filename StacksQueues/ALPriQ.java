import java.util.ArrayList;
public class ALPriQ
{
    private ArrayList<PriString> q = new ArrayList<PriString>();
    
    public void enQ(PriString p)
    {
        if ((q.size()==0)||p.getPriority()==0){
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
    
    public void enQ(String s, int i)
    {
        PriString p = new PriString(s,i);
        
        if ((q.size()==0)||p.getPriority()==0){
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
    
    public PriString deQ(){
       PriString returned = new PriString(q.get(0).getInfo(), q.get(0).getPriority());
       q.remove(0);
       return returned;
    }
    
    public PriString peek(){
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
