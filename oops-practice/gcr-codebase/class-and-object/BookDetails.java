import java.util.*;
class Book {
    String title;
    String author;
    double price;
    void takeInput(Scanner ob) {
        System.out.print("Enter book title: ");
        title = ob.nextLine();
        System.out.print("Enter book author: ");
        author = ob.nextLine();
        System.out.print("Enter book price: ");
        price = ob.nextDouble();
        ob.nextLine();
    }
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}
public class BookDetails {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        Book[] books = new Book[2];
        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter details for Book " + (i + 1));
            books[i] = new Book();
            books[i].takeInput(ob);
        }
        System.out.println("Book Details");
        for (Book book : books) {
            book.displayDetails();
        }
    }
}