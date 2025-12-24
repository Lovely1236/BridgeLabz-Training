import java.util.Scanner;
public class MaxHandshakes {
	public static int handshakes(int n){
		int ans= (n*(n-1))/2;
        return ans;
	}
    public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of Students");
		int numberOfStudents= sc.nextInt();
		int maxNoHandshakes= handshakes(numberOfStudents);
		System.out.println("Number of handshakes are--> " +maxNoHandshakes);
        sc.close();
	}
}
