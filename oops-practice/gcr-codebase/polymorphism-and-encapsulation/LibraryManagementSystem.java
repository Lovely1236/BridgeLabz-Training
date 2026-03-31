// Interface for reserving items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Class to safely store borrower information
class Borrower {
    private String name;
    private String phone;   // sensitive data

    public Borrower(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Only masked details are shown
    public String getMaskedInfo() {
        return name + " (Phone: XXXX" + phone.substring(phone.length() - 2) + ")";
    }
}

// Abstract base class
abstract class LibraryItem{
    private int itemId;
    private String title;
    private String author;
    protected boolean available = true;
    protected Borrower borrower;
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }


    // Abstract method
    abstract int getLoanDuration();
    // Concrete method
    void getItemDetails(){
        System.out.println("Item ID      : " + itemId);
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
        System.out.println("Loan Period  : " + getLoanDuration() + " days");
    }
}
// ---------------- Book ----------------
class Book extends LibraryItem implements Reservable{
   public Book(int itemId, String title, String author){
        super(itemId, title, author);
    }
    @Override
    int getLoanDuration(){
        return 14;
    }
    @Override
    public void reserveItem(){
        if (available){
            borrower = new Borrower("Amit", "9876543210");
            available = false;
            System.out.println("Book reserved successfully");
        }
    }
    @Override
    public boolean checkAvailability(){
        return available;
    }
}
// ---------------- Magazine ----------------
class Magazine extends LibraryItem implements Reservable{
    public Magazine(int itemId, String title, String author){
        super(itemId, title, author);
    }
    @Override
    int getLoanDuration(){
        return 7;
    }
    @Override
    public void reserveItem(){
        if(available){
            borrower = new Borrower("Neha", "9123456789");
            available = false;
            System.out.println("Magazine reserved successfully");
        }
    }
    @Override
    public boolean checkAvailability(){
        return available;
    }
}
// ---------------- DVD ----------------
class DVD extends LibraryItem implements Reservable{
    public DVD(int itemId, String title, String author){
        super(itemId, title, author);
    }
    @Override
    int getLoanDuration(){
        return 3;
    }
    @Override
    public void reserveItem(){
        if(available){
            borrower = new Borrower("Rahul", "9988776655");
            available = false;
            System.out.println("DVD reserved successfully");
        }
    }
    @Override
    public boolean checkAvailability(){
        return available;
    }
}
// ---------------- Main Class ----------------
public class LibraryManagementSystem{
    public static void main(String[] args){
        LibraryItem[] items = {
            new Book(1, "Java Basics", "James Gosling"),
            new Magazine(2, "Tech World", "Editorial Team"),
            new DVD(3, "Inception", "Christopher Nolan")
        };
        // Polymorphism in action
        for (LibraryItem item : items){
            item.getItemDetails();
            Reservable r = (Reservable) item;
            System.out.println("Available    : " + r.checkAvailability());
            r.reserveItem();
            System.out.println("Available    : " + r.checkAvailability());
            System.out.println("----------------------------------");
        }
    }
}
