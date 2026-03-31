import java.util.Scanner;
public class FestivalLuckyDraw{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("🎉🎆 Welcome to Diwali Mela Lucky Draw 🎉🎆");
        System.out.println("If you don't want to play the game, enter -1 to exit");
        while(true){
            System.out.print("\nEnter your lucky number: ");
            int num = sc.nextInt();
            if(num==-1){            // Exit condition
                System.out.println("Thank you for participating!");
                break;
            }
            if(num<=0){            // Invalid input check
                System.out.println("Invalid number! Try again.");
                continue;
            }
            if(num%3==0 && num%5==0){             // Winning condition
                 System.out.println("🎁 Congratulations! You won a gift!");
            }
            else{
                System.out.println("Sorry! Better luck next time.");
            }
        }
        sc.close();
    }
}
