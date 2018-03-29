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
public class Project {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        Hailstone n = new Hailstone();
        
        System.out.println(n.avgLength());
        
    }*/
    
    public static void main(String[] args)
    {
        InputGUI ig=new InputGUI();
        String s=ig.getString("Enter a String: ");
        int x=ig.getInt("Enter an integer: ");
        boolean b=ig.getBoolean("Enter true or false: "); // Defaults to ÒTrueÓ and ÒFalseÓ
        boolean b2=ig.getBoolean("Select true or false: ","Yep","Nope"); //doesnÕt use defaults
        char c=ig.getChar("Enter a single character: ");
        System.out.println("Entered String = "+s);
        System.out.println("Entered integer = "+x);
        System.out.println("Entered boolean = "+b);
        System.out.println("Entered boolean = "+b2);
        System.out.println("Entered character = "+c);


    }
    
}
