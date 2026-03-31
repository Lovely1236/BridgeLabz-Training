import java.util.*;
class Book{
    String title;
    String author;
    boolean isAvailable;
    Book(String title,String author){
        this.title=title;
        this.author=author;
        this.isAvailable=true;
    }
    void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Status: "+(isAvailable?"Available":"Checked Out"));
    }
}
public class LibraryManagementSystem{
    static void searchBook(Book[] books,String keyword){
        boolean found=false;
        for(Book book:books){
            if(book.title.toLowerCase().contains(keyword.toLowerCase())){
                book.display();
                found=true;
            }
        }
        if(!found){
            System.out.println("No book found with title containing: "+keyword);
        }
    }
    static void checkoutBook(Book[] books,String title){
        for(Book book:books){
            if(book.title.equalsIgnoreCase(title)){
                if(book.isAvailable){
                    book.isAvailable=false;
                    System.out.println(title+" has been checked out.");
                }else{
                    System.out.println(title+" is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        Book[] books=new Book[3];
        books[0]=new Book("Java Basics","James");
        books[1]=new Book("Data Structures","Mark");
        books[2]=new Book("Python Guide","Rossum");
        System.out.print("Enter partial title to search: ");
        String keyword=ob.nextLine();
        searchBook(books,keyword);
        System.out.print("Enter exact title to checkout: ");
        String title=ob.nextLine();
        checkoutBook(books,title);
        System.out.println("Updated Book List:");
        for(Book book:books){
            book.display();
        }
    }
}