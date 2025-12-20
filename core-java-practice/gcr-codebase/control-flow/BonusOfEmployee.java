import java.util.*;
public class BonusOfEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int yrsOfService = sc.nextInt(); // yrsOfService-- Years of Service of Employee

        double sal = sc.nextDouble(); // sal-- Employee Salary
        double bonus = 0;


        if (yrsOfService > 5) {

            bonus = 0.05 * sal;
        } 
        else {
            bonus = 0;
        }

        System.out.println("The bonus amount of the employee is: " + bonus);
        sc.close();
    }
}
