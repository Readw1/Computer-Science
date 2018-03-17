
public class MLList
{
    private MLNode topName; 
    private MLNode topAcct;
    
    public MLList(){ //creates an empty MLList (topName & topAcct set to null)
        topName = null;
        topAcct = null;
    }
    
    public void add(MLNode m){ //places m correctly into the doubly linked list
        MLNode temp = topName;
        MLNode temp2 = topAcct;
        
        if(topName == null && topAcct == null){
            topName = m;
            topAcct = m;
        }
        else{
            add(m, temp2);
            add2(m, temp);
        }
        
    }
    
    private void add(MLNode m, MLNode temp){
        if(temp == null){
            System.err.println("OWO whats this");
        }
        if(m.getInfo().getAcct()-topAcct.getInfo().getAcct()<0){
            m.setNextAcct(topAcct);
            topAcct = m;
        }
        else{
            if(temp.getInfo().getAcct()-m.getInfo().getAcct()<0){
                if(temp.getNextAcct()!=null&&temp.getNextAcct().getInfo().getAcct()-m.getInfo().getAcct()<0){
                    add(m, temp.getNextAcct());
                }
                else if(temp.getNextAcct()==null){
                    temp.setNextAcct(m);
                    m.setNextAcct(null);
                }
                else{
                    m.setNextAcct(temp.getNextAcct());
                    temp.setNextAcct(m);
                    
                }
            }
            else{
                m.setNextAcct(temp);
            }
        }
    }
    
    private void add2(MLNode m, MLNode temp){
        if(temp == null){
            System.err.println("OWO whats this");
        }
        if(m.getInfo().getName().compareTo(topName.getInfo().getName())<0){
            m.setNextName(topName);
            topName = m;
        }
        else{
            if(temp.getInfo().getName().compareTo(m.getInfo().getName())<0){
                if(temp.getNextName()!=null&&temp.getNextName().getInfo().getName().compareTo(m.getInfo().getName())<0){
                    add(m, temp.getNextName());
                }
                else if(temp.getNextName()==null){
                    temp.setNextName(m);
                    m.setNextName(null);
                }
                else{
                    m.setNextName(temp.getNextName());
                    temp.setNextName(m);
                    
                }
            }
            else{
                m.setNextName(temp);
            }
        }
    }
    
    public void print(){//prints two numbered lists, one ordered by name, one by acctNum
        MLNode temp = topAcct;
        int count = 1;
        
            
        
        while(2<3){
            System.out.println(count + ": " + temp.toString());
            temp = temp.getNextAcct();
            count ++;
            if(temp.getNextAcct()==null){
                System.out.println(count + ": " + temp.toString());
                break;
            }
        }
        
        System.out.println("");
        count = 1;
        temp = topName;
        while(2<3){
            
            System.out.println(count + ": " + temp.toString());
            temp = temp.getNextName();
            count ++;
            if(temp.getNextName()==null){
                System.out.println(count + ": " + temp.toString());
                break;
            }
        }
            
        
        
        
    }
    

    } 