

public class MLNode
{
    private Info myInfo;
    private MLNode nextName;
    private MLNode nextAcct;
    
    
    
    public MLNode(Info in){
        myInfo = in;
        nextName = null;
        nextAcct = null;
        
    }
    
    public Info getInfo(){
        return myInfo;
    }
    
    public String toString(){
        String returned = "";
        returned += myInfo.toString() + " ";
        if(nextName!=null){
            returned += "next name = " + nextName.getInfo().getName() + " ";
        }
        else{
            returned += "next name = null ";
        }
        
        if(nextAcct!=null){
            returned += "next acct = " + nextAcct.getInfo().getAcct() + " ";
        }
        else{
            returned += "next acct = null ";
        }
        return returned;
    }
    
    public MLNode getNextAcct(){
        return nextAcct;
    }
    
    public MLNode getNextName(){
        return nextName;
    }
    
    
    public void setNextAcct(MLNode inAc){
        nextAcct = inAc;
    }
    
    public void setNextName(MLNode inN){
        nextName = inN;
    }
    
    
}
