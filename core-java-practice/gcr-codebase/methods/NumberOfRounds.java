import java.util.*;
public class NumberOfRounds {
	 public static int noOfRounds(int a, int b, int c, int dist){
		  int perimeter= a+b+c;
          return dist/perimeter;
		  }
     public static void main(String[] args){
		 Scanner sc= new Scanner(System.in);
		 int distance=5000;
		 System.out.println("Enter side 1 in meters");
		 int s1= sc.nextInt();
		 System.out.println("Enter side 2 in meters");
		 int s2= sc.nextInt();
		 System.out.println("Enter side 3 in meters");
		 int s3= sc.nextInt();
		 int rounds= noOfRounds(s1,s2,s3,distance);
		 System.out.println("No of Rounds are--> " +rounds);
		 sc.close();
	 }   
}
