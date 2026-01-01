public class Books{
  static String libraryName;
  public String title;
  public String author;
  final int ISBN;


  // constructor
  Books(String libraryName, String title, String author, int ISBN){
    Books.libraryName = libraryName;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;

  }


  // use static variable with the help of getter and setter
  public static String getLibraryName(){
    return libraryName;

  }


  public void setLibraryName(String librayName){
    this.libraryName = librayName;

  }


  // use instance of
  public static void displayLibraryName(Books book){
    if (book instanceof Books){
      System.out.println("Library: " + book.getLibraryName());
      System.out.println("Title: " + book.title + ", Author: " + book.author + ", ISBN: " + book.ISBN);
    } 
    else{
      System.out.println("Not a Books object.");
    }
  }


  // calling from main method
  public static void main(String[] args) {
    Books b = new Books("Centeral Library", "Fire on the wings", "Lovely Pandey", 978-0134685991);
    displayLibraryName(b);


  }

}