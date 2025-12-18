import java.util.*;
public class StudentFeeSC{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

		double fees;
        fees = input.nextDouble();

        double discountPercent;
        discountPercent = input.nextDouble();

        double discount;
        double finalFees;



       
        discount = (fees * discountPercent) / 100;

        
        finalFees = fees - discount;
        System.out.println("The discount amount is INR " + discount +
                           " and final discounted fee is INR " + finalFees);
	}
}