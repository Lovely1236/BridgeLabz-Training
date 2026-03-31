import java.util.Random;
import java.util.*;

public class SankeLadder{
    public static int diceNumber(){
        Random rand=new Random();
        int number= rand.nextInt(6)+1;
        System.out.println("you get "+number);
        int choice =rand.nextInt(3);
        System.out.println("As a choice you get "+choice);
        if(choice==1)
        return number;
        if(choice==2)
        return number*-1;
        else return 0;
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Snake Ladder Game\n");
        int player1=0,player2=0;
        Random ran=new Random();
        System.out.println("For Options:\n0:No Play\n1:Ladder\n2:Snake");
        while(player1<100 && player2<100){
            System.out.println("Player 1 chance:");
            
            int giveNumber=diceNumber();
            
            player1+=giveNumber;
            System.out.println("Player 2 chance:");
            int giveNumber2=diceNumber();
            player2+=giveNumber2;

        }
        if(player1>=100)
        System.out.printf("Player 1 won with a score of %d",player1);
        else 
        System.out.printf("Player 2 won with a score of %d",player2);

        
        
            
            

            
            
            
        }

    

    
}