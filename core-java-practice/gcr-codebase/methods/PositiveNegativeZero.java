import java.util.*;
public class PositiveNegativeZero {
	public static int numCheck(int num){
		if(num<0)
			return -1;
		else if(num>0)
			return 1;
		else return 0;
	}
    public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter integer");
		int num= sc.nextInt();
		int res= numCheck(num);
		if(res==-1)
	    	System.out.println("Negative Number");
		else if(res== 1)
			System.out.println("Positive Integer");
		else
			System.out.println("Zero");
	    sc.close();
	}
}
