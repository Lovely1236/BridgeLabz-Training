import java.util.*;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        
        if(number>0 && power>=0){
        
        for(int i = 1; i <= power; i++) {
            result = result * number;
        }
        
        System.out.println(number + " raised to the power of " + power + " is " + result);
    }
        sc.close();
    }
}
