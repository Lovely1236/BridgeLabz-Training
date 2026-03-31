import java.util.*;
public class LineComparison{
    public static void main(String args[]){
        Scanner ob = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation");
        double line1Length = length(ob, 1);//Use Case 1
        double line2Length = length(ob, 2);
        compareLines(line1Length, line2Length);// Use Case 2
        compareTo(line1Length,line2Length);// Use Case 3
    }


    // Use Case 1
    public static double length(Scanner ob, int lineNumber){
        System.out.println("Enter coordinates for Line " + lineNumber);
        System.out.print("Enter value of x1: ");
        int x1 = ob.nextInt();
        System.out.print("Enter value of y1: ");
        int y1 = ob.nextInt();
        System.out.print("Enter value of x2: ");
        int x2 = ob.nextInt();
        System.out.print("Enter value of y2: ");
        int y2 = ob.nextInt();
        double lengthOfLine =Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Length of Line " + lineNumber + ": " + lengthOfLine);
        return lengthOfLine;
    }

    
    // Use Case 2
    public static void compareLines(double length1, double length2){
        Double line1 = length1;
        Double line2 = length2;
        System.out.println("Comparing both lines...");
        if(line1.equals(line2)){
            System.out.println("Both lines are equal");
        } 
        else{
            System.out.println("Both lines are NOT equal");
        }
    }



    //Use Case 3
    public static void compareTo(double length1,double length2){
        Double line1 = length1;
        Double line2 = length2;
        int result = line1.compareTo(line2);
        if(result==0){
            System.out.println("Both lines are equal");
        } 
        else if(result>0){
            System.out.println("Line 1 is greater than Line 2");
        }
        else{
            System.out.println("Line 1 is less than Line 2");
        }
    }
}