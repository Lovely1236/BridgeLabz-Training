import java.util.*;

class Contact {
  private String name;
  private long number;

  Contact(String name, long number) {
    this.name = name;
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public long getNumber() {
    return number;
  }
}

public class ContactOrganizer {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    List<Contact> contact = new ArrayList<>();

    // default contacts
    contact.add(new Contact("Shivam", 9772468529L));
    contact.add(new Contact("Aman", 9123456789L));
    contact.add(new Contact("Rohit", 9988776655L));

    System.out.println("Welcome to Phone Contact Organizer");

    while (true) {
      System.out.println("\nPress 1: Add  2: Search  3: Delete  4:Display  0: Exit");
      int choice = sc.nextInt();

      // EXIT CONDITION
      if (choice == 0) {
        System.out.println("Exiting Contact Organizer...");
        break;
      }

      // ADD CONTACT
      if (choice == 1) {
        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter mobile number: ");
        long number = sc.nextLong();

        // ✅ digit count check
        if (String.valueOf(number).length() != 10) {
          System.out.println("Invalid number! Mobile number must be 10 digits.");
          continue;
        }

        boolean exists = false;
        for (Contact c : contact) {
          if (c.getNumber() == number) {
            exists = true;
            break;
          }
        }

        if (exists) {
          System.out.println("Contact Already Exists!");
        } else {
          contact.add(new Contact(name, number));
          System.out.println("Contact Added Successfully!");
        }
      }

      // SEARCH CONTACT
      else if (choice == 2) {
        System.out.print("Enter name to search: ");
        String search = sc.next();

        boolean found = false;
        for (Contact c : contact) {
          if (c.getName().equalsIgnoreCase(search)) {
            System.out.println("Name: " + c.getName() +
                ", Number: " + c.getNumber());
            found = true;
            break;
          }
        }

        if (!found) {
          System.out.println("Contact Not Found!");
        }
      }

      // DELETE CONTACT
      else if (choice == 3) {
        System.out.print("Enter name to delete: ");
        String del = sc.next();

        boolean found = false;
        for (int i = 0; i < contact.size(); i++) {
          if (contact.get(i).getName().equalsIgnoreCase(del)) {
            contact.remove(i);
            found = true;
            System.out.println("Contact Deleted Successfully!");
            break;
          }
        }

        if (!found) {
          System.out.println("Contact Not Found!");
        }
      }else if(choice==4){
        for (Contact display : contact) {
          System.out.println("Name -: "+display.getName()+" Contact Number -: "+display.getNumber());
        }
      }else {
        System.out.println("Invalid choice! Try again.");
      }
    }

    sc.close();
  }
}