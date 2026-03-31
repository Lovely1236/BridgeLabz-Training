import java.util.*;
public class BonusOfEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int yrsOfService = sc.nextInt(); // yrsOfService-- Years of Service of Employee

        double sal = sc.nextDouble(); // sal-- Employee Salary
        double bonus = 0;

        // Calculation of Bonus

        if (yrsOfService > 5) { // If Years of Service is more than 5 years

            bonus = 0.05 * sal; // Bonus is 5% of Salary
        } 
        else {
            bonus = 0; // No Bonus
        }

        System.out.println("The bonus amount of the employee is: " + bonus);
        sc.close();
    }
}
