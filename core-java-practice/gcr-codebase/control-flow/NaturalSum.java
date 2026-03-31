import java.util.*;
public class NaturalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0) {
            System.out.println("It is a natural number ");
        }
        int FormulaSum = number(number + 1) / 2;
        int sum = 0;
        while (i > 0) {
            sum += i;
            i++;
        }
        if (FormulaSum == sum)
            System.out.println(sum);
    }

}