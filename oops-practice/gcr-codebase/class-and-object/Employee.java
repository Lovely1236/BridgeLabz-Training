import java.util.*;
class Employee{
    String name;
    int id;
    double salary;
    void takeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        id = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        salary = scanner.nextDouble();
    }
    void displayDetails(){
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}
class EmployeeDetails{
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.takeInput();
        emp.displayDetails();
    }
}