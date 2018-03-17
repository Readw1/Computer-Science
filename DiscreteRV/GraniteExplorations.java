
public class GraniteExplorations
{
    
    public static void explore(){
        int[] weights = new int[7];
        int[] numBlocks = new int[20];
        int totWeight = 0;
        int totBlocks = 0;
        boolean truckLimit = false;
        
        for(int c = 0; c<100000; c++){
            //create temp block for overflow on a truck
            Block temp = new Block();
            //create new truck
            Truck t = new Truck();
            
            //if the last truck couldn't fit the last block, add the temp block
            if(truckLimit){
                t.addBlock(temp);
            }
            
            //set the truck to be not full
            truckLimit = false;
            
            //if the truck isn't full, add another block
            while(!truckLimit){
                //create new block
                Block in = new Block();
                
                //add block, if the weight would go over, do not add it and set the truck to full
                truckLimit = t.addBlock(in);
                
                //if the truck is full, set the temp block to the block that would have been added
                if(truckLimit){
                    temp.setBlock(in);
                }
            }
            //store data
            totWeight += t.getCurrentWt();
            totBlocks += t.getBlocks();
            
            if(t.getCurrentWt()<=8000){
                weights[0]++;
            }
            else if(t.getCurrentWt()>8000&&t.getCurrentWt()<=8500){
                weights[1]++;
            }
            else if(t.getCurrentWt()>8500&&t.getCurrentWt()<=9000){
                weights[2]++;
            }
            else if(t.getCurrentWt()>9000&&t.getCurrentWt()<=9250){
                weights[3]++;
            }
            else if(t.getCurrentWt()>9250&&t.getCurrentWt()<=9500){
                weights[4]++;
            }
            else if(t.getCurrentWt()>9500&&t.getCurrentWt()<=9750){
                weights[5]++;
            }
            else if(t.getCurrentWt()>9750){
                weights[6]++;
            }
            
            numBlocks[t.getBlocks()]++;
        }
        
        double avgWeight = totWeight/100000.0;
        double avgBlocks = totBlocks/100000.0;
        
        System.out.println("Average weight: " + avgWeight);
        System.out.println("Average number of Blocks: " + avgBlocks);
        System.out.println("");
        System.out.println("Distribution of weights");
        
        System.out.print("[<= 8000] " + weights[0] + " ");
        System.out.print("(8000,8500] " + weights[1] + " ");
        System.out.print("(8500,9000] " + weights[2] + " ");
        System.out.print("(9000,9250] " + weights[3] + " ");
        System.out.print("(9250,9500] " + weights[4] + " ");
        System.out.print("(9500,9750] " + weights[5] + " ");
        System.out.print("(9750,10000] " + weights[6] + " ");
        
        System.out.println("");
        System.out.println("Distribution of blocks");
        //print out block distribution with 10 blocks per line
        int J = 0;
        for(int c = 0; c<numBlocks.length; c++){
            if(numBlocks[c]!=0){
                System.out.print((c) + " Blocks: " + numBlocks[c] + "| ");
                J++;
            }
            if((J+1)%10 == 0){
                System.out.println("");
                J++;
            }
            
        }
        
        
        
        
        
    }
    
    public static void exploreEfficiently(){
        int[] weights = new int[2001];
        int[] numBlocks = new int[20];
        int totWeight = 0;
        int totBlocks = 0;
        boolean truckLimit = false;
        
        Block temp = new Block();
        Block tempIn = new Block();
        Block tempO = new Block();
        Block o = new Block();
        
        for(int c = 0; c<100000; c++){
            Truck t = new Truck();
            //if the last truck was full, efficiently add the two blocks that were left behind
            if(truckLimit){
                temp.setBlock(t.addBlockEfficient(tempIn,tempO));
                //set truck to empty
                truckLimit = false;
            }
            while(!truckLimit){
                Block in = new Block(); //randomized block
                o.setBlock(temp); //block that was unused last time
                //if the truck did not add a block last time, set the truck to be full
                if(o.getWeight()==0){
                    truckLimit = true;
                }
                if(!truckLimit){
                    //if the truck isnt full, add the best block of the two
                    //set the temp block to the one that wasn't added
                    temp.setBlock(t.addBlockEfficient(in,o));
                    //store the values of the blocks in temp blocks
                    tempIn.setBlock(in);
                    tempO.setBlock(o);
                }
            }
            //store data
            totWeight += t.getCurrentWt();
            totBlocks += t.getBlocks();
            
            if(t.getCurrentWt()<=8000){
                weights[0]++;
            }
            else if(t.getCurrentWt()>8000&&t.getCurrentWt()<=8500){
                weights[1]++;
            }
            else if(t.getCurrentWt()>8500&&t.getCurrentWt()<=9000){
                weights[2]++;
            }
            else if(t.getCurrentWt()>9000&&t.getCurrentWt()<=9250){
                weights[3]++;
            }
            else if(t.getCurrentWt()>9250&&t.getCurrentWt()<=9500){
                weights[4]++;
            }
            else if(t.getCurrentWt()>9500&&t.getCurrentWt()<=9750){
                weights[5]++;
            }
            else if(t.getCurrentWt()>9750){
                weights[6]++;
            }
            
            numBlocks[t.getBlocks()]++;
        }
        
        double avgWeight = totWeight/100000.0;
        double avgBlocks = totBlocks/100000.0;
        
        System.out.println("Average weight: " + avgWeight);
        System.out.println("Average number of Blocks: " + avgBlocks);
        System.out.println("");
        System.out.println("Distribution of weights");
        //print out weight distribution with 10 weights per line
        System.out.print("[<= 8000] " + weights[0] + " ");
        System.out.print("(8000,8500] " + weights[1] + " ");
        System.out.print("(8500,9000] " + weights[2] + " ");
        System.out.print("(9000,9250] " + weights[3] + " ");
        System.out.print("(9250,9500] " + weights[4] + " ");
        System.out.print("(9500,9750] " + weights[5] + " ");
        System.out.print("(9750,10000] " + weights[6] + " ");
        System.out.println("");
        System.out.println("Distribution of blocks");
        //print out block distribution with 10 blocks per line
        int J = 0;
        for(int c = 0; c<numBlocks.length; c++){
            if(numBlocks[c]!=0){
                System.out.print((c) + " Blocks: " + numBlocks[c] + "| ");
                J++;
            }
            if((J+1)%10 == 0){
                System.out.println("");
                J++;
            }
            
        }
        
        
    }
    
    
}
    

