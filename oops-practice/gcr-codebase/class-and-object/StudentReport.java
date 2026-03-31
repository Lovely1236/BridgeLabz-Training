import java.util.*;
class Student{
    String name;
    String rollNumber;
    double mark1;
    double mark2;
    double mark3;
    void takeInput(Scanner ob){
        System.out.println("Enter Student Name");
        name = ob.nextLine();
        System.out.println("Enter Student Roll Number");
        rollNumber = ob.nextLine();
        System.out.println("Enter Mark 1");
        mark1 = ob.nextDouble();
        System.out.println("Enter Mark 2");
        mark2 = ob.nextDouble();
        System.out.println("Enter Mark 3");
        mark3 = ob.nextDouble();
    }
    String calculateGrade(){
        double avg = (mark1+mark2+mark3)/3;
        if(avg>=75){
            return "A";
        } 
        else if(avg>=65){
            return "B";
        } 
        else if(avg>=50){
            return "C";
        }
        else{
            return "D";
        }
    }
    void displayReport(){
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
        System.out.println();
    }
}
public class StudentReport{
    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = ob.nextInt();
        Student[] students = new Student[count];
        for(int i=0;i<count;i++){
            System.out.println("Enter details for Student "+(i+1));
            students[i] = new Student();
            students[i].takeInput(ob);
        }

        for(Student student : students){
            student.displayReport();
        }
    }
}