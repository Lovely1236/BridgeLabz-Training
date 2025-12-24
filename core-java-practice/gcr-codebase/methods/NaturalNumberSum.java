import java.util.*;
public class NaturalNumberSum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        sum(number);
        sc.close();
    }
    static void sum(int number){
        int sum=0;
        for(int i=1;i<=number;i++)
            sum+=i;
        System.out.println(sum);
    }
}