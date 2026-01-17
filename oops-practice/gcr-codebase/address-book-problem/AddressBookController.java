package gcr_codebase.address_book_problem;
import java.util.*;
public class AddressBookController {
    public static void main(String[] args) {
    		 System.out.println("------------------WELCOME TO ADDRESS BOOK PROGRAM------------------------------");
    		 Scanner sc = new Scanner(System.in);
    	     AddressBookService service = new AddressBookService();
    	     while (true){
    	            System.out.println("\n--- ADDRESS BOOK MENU ---");
    	            System.out.println("1. Add Contact");
    	            System.out.println("2. Exit");
    	            System.out.println("Choice??: ");

    	            int ch = sc.nextInt();
    	            sc.nextLine();
    	            
    	            switch (ch) {

                    // UC1
                    case 1 -> {
                        System.out.println("Name: ");
                        String name = sc.nextLine();
                        System.out.println("Phone: ");
                        String phone = sc.nextLine();
                        System.out.println("Email: ");
                        String email = sc.nextLine();
                        System.out.println("City: ");
                        String city = sc.nextLine();
                        System.out.println("State: ");
                        String state = sc.nextLine();

                        service.addContact(new ContactModel(name, phone, email, city, state));
                    }
                    case 2 -> {
                        System.out.println("Exiting...");
                        return;
                    }
    	            }
    	     } 
    }
    
    
}
