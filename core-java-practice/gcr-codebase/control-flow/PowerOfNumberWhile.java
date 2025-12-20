import java.util.*;
public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        int i = 0;

        if(number>0 && power>=0){
            while(i <= power) {
                result = result * number;
                i++;
            }

            System.out.println(number + " raised to the power of " + power + " is " + result);
        }
        sc.close();
    }
}