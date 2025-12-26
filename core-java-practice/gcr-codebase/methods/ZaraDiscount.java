import java.util.Scanner;

public class ZaraDiscount {

    // Method to calculate bonus percentage
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return salary * 0.02; // 2% bonus
        }
    }

    // Method to generate salary, service and calculate bonus
    public static void salaryAndServices() {

        int minSalary = 100000;
        int maxSalary = 999999;
        int minYears = 1;
        int maxYears = 60;

        double totalBonus = 0;

        for (int i = 1; i <= 10; i++) {

            int salary = (int) (Math.random() * (maxSalary - minSalary + 1) + minSalary);
            int years = (int) (Math.random() * (maxYears - minYears + 1) + minYears);

            double bonus = calculateBonus(salary, years);
            double newSalary = salary + bonus;

            totalBonus += bonus;

            System.out.println("Employee " + i);
            System.out.println("Salary: " + salary);
            System.out.println("Years of Service: " + years);
            System.out.println("Bonus: " + bonus);
            System.out.println("New Salary: " + newSalary);
            System.out.println("---------------------------");
        }

        System.out.println("Total Bonus Paid by Company: " + totalBonus);
    }

    public static void main(String[] args) {
        salaryAndServices();
    }
}