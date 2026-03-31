import java.util.Scanner;

public class IllegalArgumentDemo{

    // This is to generate IllegalArgumentException
    
    public static void generateException(int age){
        if(age<0) {
            
            throw new IllegalArgumentException("Age cannot be negative");
        }
        
        System.out.println("Valid age: " + age);
    }

    
    //This is to handle IllegalArgumentException
    
    public static void handleIllegalArgumentException(int age){
        try {
            generateException(age);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        }
    }


    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        handleIllegalArgumentException(age);
        sc.close();
    }
}
