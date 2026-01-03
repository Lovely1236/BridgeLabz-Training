
class Library{
    String title;
    int publicationYear;

    Library(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("\n----------------------------");
        System.out.println("Book name is -: " + title);
        System.out.println("publication year is  -: " + publicationYear);

    }
}

// Manager class - Outside Library
class Author extends Library {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Name of the author is -: " + name);
        System.out.println("Bio of the author is -: " + bio);
    }
}

// Main class to run the code
public class LibraryManagement{
    public static void main(String[] args) {
        Library l = new Library("Mindset", 2016);
        Author a = new Author("Let go", 2018, "Lovely", "Writer");

        l.displayInfo();
        a.displayInfo();
    }
}