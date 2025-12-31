import java.util.*;
class Circle{
    double radius;
    void takeInput(){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        radius = ob.nextDouble();
    }

    double calculateArea(){
        return Math.PI * radius * radius;
    }

    double calculateCircumference(){
        return 2 * Math.PI * radius;
    }

    void displayResult(){
        System.out.println("Area of circle: "+ calculateArea());
        System.out.printf("Circumference of circle: "+calculateCircumference());
    }
}



public class CircleCalculation{
    public static void main(String[] args){
        Circle circle = new Circle();
        circle.takeInput();
        circle.displayResult();
    }
}