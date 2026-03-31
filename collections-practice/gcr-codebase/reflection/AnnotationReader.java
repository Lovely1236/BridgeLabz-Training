package reflection;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name="Parth Gupta")
class Book {
}

public class AnnotationReader {

    public static void main(String[] args) {
        Class<Book> cls=Book.class;

        Author author=cls.getAnnotation(Author.class);

        System.out.println("Author:"+author.name());
    }
}