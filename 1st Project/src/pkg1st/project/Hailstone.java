/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1st.project;
/**
 *
 * @author readbrown
 */

public class Hailstone {
    
    public static void printHailstones(int start, int howMany){
        int check = start;
        for(int c = 0; c<howMany; c++){
            System.out.print(check + ", ");
            if(check%2==0){
                check/=2;
            }
            else{
                check*=3;
                check++;
            }
            
        }
    }
    
    public static int countHailstones(int start){
        int count = 0;
        double check = start;
        while(check!=1){
            
            if(check%2==0){
                check/=2;
            }
            else{
                check*=3;
                check++;
            }
            count++;
            
           
            
        }
        count++;
        return count;
    }
    
    public static int longestHail(){
        int longest = 0;
        int startVal = 0;
        for(int c = 1; c<1000001; c++){
            int m = countHailstones(c);
            if(m>=longest){
                longest = m;
                startVal =c;
            }
           
        }
        System.out.println(longest);
        return startVal;
    }
    
    public static int [] allinArray(){
        int[] lengths = new int[527];
        double[] proportions = new double[527];
        int longest = 0;
        int startVal = 0;
        for(int c = 1; c<1000001; c++){
            int m = countHailstones(c);
            lengths[m]++;
            if(m>=longest){
                longest = m;
                startVal =c;
            }
           
        }
        for(int c= 0; c<526; c++){
            proportions[c]=1.0*lengths[c]/1000000;
        }
        System.out.println(longest);
        System.out.println(startVal);
        int L = 0;
        for(int c = 0; c<lengths.length; c++){
            
            System.out.print(c + " Steps: " + lengths[c] + "| ");
            L++;
           
            if((L+1)%10 == 0){
                System.out.println("");
                L++;
            }
            
        }
        
        int k = 0;
        for(int c = 0; c<proportions.length; c++){
            
            System.out.print(c + " Prop: " + proportions[c] + "| ");
            k++;
           
            if((k+1)%10 == 0){
                System.out.println("");
                k++;
            }
            
        }
        System.out.println(longest);
        return lengths;
    }
    
    public static int[] hailArray(){
        int[] lengths = new int[527];
        double[] proportions = new double[527];
        
        for(int c= 1; c<1000001;c++){
            lengths[countHailstones(c)]++;
        }
        
        for(int c= 0; c<526; c++){
            proportions[c]=1.0*lengths[c]/1000000;
        }
        
        int L = 0;
        for(int c = 0; c<lengths.length; c++){
            
            System.out.print(c + " Steps: " + lengths[c] + "| ");
            L++;
           
            if((L+1)%10 == 0){
                System.out.println("");
                L++;
            }
            
        }
        
        int k = 0;
        for(int c = 0; c<proportions.length; c++){
            
            System.out.print(c + " Prop: " + proportions[c] + "| ");
            k++;
           
            if((k+1)%10 == 0){
                System.out.println("");
                k++;
            }
            
        }
        return lengths;
        
        
    }
    
    
    public static double avgLength(){
        int[] l = allinArray();
        double tot = 0;
        for(int c = 0; c<526;c++){
            tot+=l[c]*c;
        }
        return tot/1000000;
    }
}
