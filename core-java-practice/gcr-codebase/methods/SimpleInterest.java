import java.util.*;
public class SimpleInterest{
	public static double si(double p, double r, int t){
		double interest =(p*r*t)/100;
		return interest;
	}
    public static void main(String[] args){
	    Scanner sc= new Scanner(System.in);
		System.out.println("Enter principal amt");
		double principal=sc.nextDouble();
		System.out.println("Enter rate");
		double rate=sc.nextDouble();
		System.out.println("Enter time in months");
		int time= sc.nextInt();
		double interest= si(principal,rate,time);
		System.out.println("The Simple Interest is " + interest+ " for Principal "+ principal +", Rate of Interest "+rate+ " and Time"+ time );
		sc.close();
	}
}
