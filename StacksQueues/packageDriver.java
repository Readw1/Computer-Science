import java.util.Scanner;
public class packageDriver
{
    static boolean running = true;
    public static void main(String[] args){
        genPriQ packs = new genPriQ();
        Scanner option = new Scanner(System.in);
        
        
        while (running){
            int choice = 0;
            System.out.println("1: Add a package");
            System.out.println("2: Remove a package");
            System.out.println("3: Get Number");
            System.out.println("4: Print all packages");
            System.out.println("5: Exit");
            choice = option.nextInt();
            option.nextLine();
            
            if(choice == 1){
                System.out.println("Code: ");
                String code = option.nextLine();
                
                System.out.println("Timestamp: ");
                String time = option.nextLine();
                
                Time tim = new Time(time);
                
                System.out.println("Priority: ");
                int priority = option.nextInt();
                option.nextLine();
                
                
                Package in = new Package(code, tim, priority);
                packs.enQ(in);
                System.out.println(in.getCode()+ " has been added");
            }
            else if(choice == 2){
                if(packs.getSize()<=0){
                    System.out.println("No Packages to remove");
                }
                else{
                
                    System.out.println(packs.deQ());
                }
                
            }
            else if(choice == 3){
                if(packs.getSize()==1){
                    System.out.println("There is 1 package remaining.");
                }
                else{
                    System.out.println("There are " + packs.getSize() + " packages remaining.");
                }
            }
            else if (choice == 4){
                if(packs.getSize()==0){
                    System.out.println("There are no packages to print");
                }
                else{
                    packs.printQueue();
                }
            }
            else if(choice == 5){
                if(packs.getSize()==1){
                    System.out.println("до свидания! There is 1 package remaining.");
                }
                else{
                    System.out.println("до свидания! There are " + packs.getSize() + " packages remaining.");
                }
                running = false;
            }
        }
        
    }
}
