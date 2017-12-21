import java.util.Scanner;
public class bookDriver
{
    static boolean running = true;
    public static void main(String[] args){
        generalStack books = new generalStack();
        Scanner option = new Scanner(System.in);
        while (running){
            int choice = 0;
            System.out.println("1: Add a book");
            System.out.println("2: Remove a book");
            System.out.println("3: Get Number");
            System.out.println("4: Exit");
            choice = option.nextInt();
            option.nextLine();
            
            if(choice == 1){
                System.out.println("Title: ");
                String title = option.nextLine();
                
                System.out.println("Timestamp: ");
                String time = option.nextLine();
                Book in = new Book(title, time);
                books.push(in);
                System.out.println(in.getName()+ " has been added");
            }
            else if(choice == 2){
                
                System.out.println(books.pop());
                
            }
            else if(choice == 3){
                if(books.getSize()==1){
                    System.out.println("There is 1 book remaining.");
                }
                else{
                    System.out.println("There are " + books.getSize() + " books remaining.");
                }
            }
            else if(choice == 4){
                if(books.getSize()==1){
                    System.out.println("до свидания! There is 1 book remaining.");
                }
                else{
                    System.out.println("до свидания! There are " + books.getSize() + " books remaining.");
                }
                running = false;
            }
        }
        
    }
}
