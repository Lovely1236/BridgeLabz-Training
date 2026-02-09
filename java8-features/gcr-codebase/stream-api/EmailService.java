package streamApi;

import java.util.*;

public class EmailService {
    public static void main(String[] args){
        List<String> emails=List.of("a@gmail.com","b@gmail.com","c@gmail.com");

        emails.forEach(email->sendEmailNotification(email));
    }

    static void sendEmailNotification(String email){
        System.out.println("Email sent to:"+email);
    }
}