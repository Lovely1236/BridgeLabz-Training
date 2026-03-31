import java.util.*;
public class LeapYear {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int year=ob.nextInt();
        if(check(year))
            System.out.println("True");
        else
            System.out.println("False");
        ob.close();
    }
    public static boolean check(int year){
        if (year < 1582) {
            System.out.println("Year must be 1582 or later");
        } 
        else if (year % 400 == 0) {
            return true;
        } 
        else if (year % 100 == 0) {
            return false;
        } 
        else if (year % 4 == 0) {
            return true;
        } 
        else {
            return false;
        }
        return false;
    }
}