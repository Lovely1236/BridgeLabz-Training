class Employee{
    String name, id;
    Double salary;
    void displayDetails(){
        System.out.println("I am an employee");
    }
}
class Manager extends Employee{
    int teamSize;
    void displayDetails(){
    System.out.println("I am a Manager");
    }
}
class Developer extends Employee{
    String programmingLanguage;
    void displayDetails(){
    System.out.println("I am a Developer");
    }
}
class Intern extends Employee{
    void displayDetails(){
    System.out.println("I am an Intern");
    }
}
class EmployeeMS{
    public static void main(String[] args){
        Employee emp= new Employee();
        Employee mng= new Manager();
        Employee dev= new Developer();
        Employee inter= new Intern();
        emp.displayDetails();
        mng.displayDetails();
        dev.displayDetails();
        inter.displayDetails();
    }
}