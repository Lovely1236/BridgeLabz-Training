import java.util.*;
public class SpringSeason {
	public static boolean spring(int day,String month){
		if(month.equalsIgnoreCase("March") && day>=20 && day<=31 || month.equalsIgnoreCase("April") && day>=1 && day<=30 || month.equals("May")&&day>=1&&day<=31||month.equals("June")&&day>=1&&day<=20)
            return true;
        else
            return false;
	}
    public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter day");
		int day= sc.nextInt();
		System.out.println("Enter month");
		String month= sc.next();
		boolean ans= spring(day, month);
		if(ans == true)
			System.out.println("Its a Spring Season");
		else
			System.out.println("Not a Spring Season");
		sc.close();
	}
}
