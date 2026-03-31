import java.util.*;
public class PollingBoothSystem{
    public static void main(String[] args){
        System.out.println("Welcome to THE PBS 💅🦹");
        System.out.println("Here you get a lot of options to choose, unlike life 😌");
        Scanner sc = new Scanner(System.in);
        int vote1 = 0, vote2 = 0, vote3 = 0;
        System.out.println("Jaaniye apni parties ko:");
        System.out.println("1. Kaam Karenge");
        System.out.println("2. Sirf Baat Karenge, Kaam nahi");
        System.out.println("3. Kuch nahi karenge");
        while (true){
            System.out.println("\nEnter your age (-1 to exit):");
            int age = sc.nextInt();
            if(age == -1){            // Exit condition
                System.out.println("Exiting.. Aapka use ho chuka hai 😄 Thank you!");
                break;
            }
            if(age < 18){            // Eligibility check
                System.out.println("You are not eligible to vote");
                continue;
            }
            System.out.println("Enter your vote (1 / 2 / 3):");
            int choice = sc.nextInt();
            if(choice == 1) {
                vote1++;
            } else if(choice == 2){
                vote2++;
            } else if(choice == 3){
                vote3++;
            } else{
                System.out.println("Invalid vote");
            }
        }        // Display results
        System.out.println("\n---- Voting Results ----");
        System.out.println("Candidate A Votes: " + vote1);
        System.out.println("Candidate B Votes: " + vote2);
        System.out.println("Candidate C Votes: " + vote3);
        sc.close();
    }
}
