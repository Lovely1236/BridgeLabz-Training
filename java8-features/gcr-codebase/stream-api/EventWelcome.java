package streamApi;
import java.util.*;

public class EventWelcome {
    public static void main(String[] args){
        List<String> attendees=List.of("Parth","Aman","Riya");

        attendees.forEach(name->System.out.println("Welcome "+name+" to the event!"));
    }
}