package collectors;
import java.util.*;
import java.util.stream.*;

class Book{
    String genre;
    int pages;
    Book(String genre,int pages){
        this.genre=genre;
        this.pages=pages;
    }
    String getGenre(){return genre;}
    int getPages(){return pages;}
}

public class LibraryStaticsApp{
    public static void main(String[] args){
        List<Book> books=Arrays.asList(
            new Book("Tech",300),
            new Book("Tech",500),
            new Book("Fiction",200)
        );
        Map<String,IntSummaryStatistics> stats=books.stream().collect(Collectors.groupingBy(Book::getGenre,Collectors.summarizingInt(Book::getPages)));
        System.out.println(stats);
    }
}