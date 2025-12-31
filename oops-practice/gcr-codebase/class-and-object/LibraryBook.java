public class LibraryBook{
  String title;
  String author;
  double price;
  boolean avilablity;

  // constructor

  LibraryBook(String title, String author, int price, boolean avilablity){
    this.title = title;
    this.author = author;
    this.price = price;
    this.avilablity = avilablity;

  }


  void displayThings(){
    System.err.println("Title of the book -:" + title);
    System.out.println("Author of the book -:" + author);
    System.out.println("Price of the book -:" + price);
    System.out.println("Avalablity -:" + avilablity);
    System.err.println("Title of the book -:" + title);
    System.out.println("Author of the book -:" + author);
    System.out.println("Price of the book -:" + price);
    System.out.println("Avalablity -:" + avilablity);

  }

  // making a constructor for calling the display method
  public static void main(String[] args){
    
    LibraryBook b1 = new LibraryBook("2States", "Chetan Bhagat", 500, true);
    LibraryBook b2 = new LibraryBook("Wings Of Fire", "Abdul kalam.A.P.J", 500, false);

    b1.displayThings();
    b2.displayThings();
  }

}