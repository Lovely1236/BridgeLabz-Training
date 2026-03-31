package streamApi;
import java.time.*;
import java.util.*;
class Member {
    String name;
    LocalDate expiryDate;

    Member(String name,LocalDate expiryDate){
        this.name=name;
        this.expiryDate=expiryDate;
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    public String toString(){
        return name+" | Expiry:"+expiryDate;
    }
}

public class GymMembers {
    public static void main(String[] args){
        List<Member> members=List.of(
            new Member("Amit",LocalDate.now().plusDays(10)),
            new Member("Rohit",LocalDate.now().plusDays(40)),
            new Member("Neha",LocalDate.now().plusDays(25))
        );
        members.stream()
            .filter(m->m.getExpiryDate().isBefore(LocalDate.now().plusDays(30)))
            .forEach(System.out::println);
    }
}