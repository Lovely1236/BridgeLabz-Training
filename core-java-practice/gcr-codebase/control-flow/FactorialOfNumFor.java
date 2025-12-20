import java.util.*; 


public class FactorialOfNumFor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int factorial = 1;

        for (int j = 1; j <= num; j++) {
            factorial *= j;
        }

        System.out.println("The factorial of " + num + " is " + factorial);
        sc.close();
    }
}