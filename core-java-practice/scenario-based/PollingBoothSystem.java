import java.util.*;
public class PollingBoothSystem {
  public static void main(String[] args){
   Systm.out.println("Welcome to THE PBS💅🦹");
   System.out.println("Here you get a lot of options to choose unlike life");
    Scanner sc = new Scanner(System.in);
    int vote1=1, vote2=2, vote3=3;
    System.out.println("Jaaniye apni parties ko:");
    System.out.println("1. Kaam Karenge");
    System.out.println("2. Sirf Baat Karenge Kaam nahi ");
    System.out.println("3. Kuch nahi karenge ");
    
    while(true){
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        if(age<18){
            System.out.println("You are not eligible to vote");
            break;
        }
        if(age==-1){
            System.out.println("Exiting..Apka Use ho chuka hai. Thank you!");
            break;
        }
        System.out.println("Enter your vote (1/2/3) or -1 to exit:");
        int vote = sc.nextInt();
        
    }
   
  }
}