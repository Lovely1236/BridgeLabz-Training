class BookLibrarySystem{
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    

    public Book(String ISBN, String title, String author){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }



    // Setter & Getter for author
    public void setAuthor(String author){
        this.author = author;
    }


    public String getAuthor(){
        return author;
    }
}




class EBook extends BookLibrarySystem{

    public EBook(String ISBN, String title, String author){
        super(ISBN, title, author);
    }

    
    public void displayBookInfo(){
        System.out.println("ISBN: " + ISBN);     // public
        System.out.println("Title: " + title);   // protected
        System.out.println("Author: " + getAuthor()); // private via getter
    }
}
