package streamApi;
import java.util.*;
class Movie {
    String name;
    double rating;
    int year;
    Movie(String name,double rating,int year){
        this.name=name;
        this.rating=rating;
        this.year=year;
    }
    public double getRating(){
        return rating;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return name+" | Rating:"+rating+" | Year:"+year;
    }
}
public class TopMovies {
    public static void main(String[] args){
        List<Movie> movies=List.of(
            new Movie("Inception",8.8,2010),
            new Movie("Avatar",7.9,2009),
            new Movie("Interstellar",8.6,2014),
            new Movie("Joker",8.4,2019),
            new Movie("Dune",8.2,2021),
            new Movie("Oppenheimer",8.9,2023)
        );
        movies.stream().filter(m->m.getYear()>2010).sorted((a,b)->Double.compare(b.getRating(),a.getRating()))
            .limit(5)
            .forEach(System.out::println);
    }
}