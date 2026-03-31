class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    void displayPerson(){
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
    }
}
class Teacher extends Person{
    String subject;
    Teacher(String name,int age,String subject){
        super(name,age);
        this.subject=subject;
    }
    void displayRole(){
        displayPerson();
        System.out.println("Role:Teacher");
        System.out.println("Subject:"+subject);
    }
}
class Student extends Person{
    String grade;
    Student(String name,int age,String grade){
        super(name,age);
        this.grade=grade;
    }
    void displayRole(){
        displayPerson();
        System.out.println("Role:Student");
        System.out.println("Grade:"+grade);
    }
}
class Staff extends Person{
    String department;
    Staff(String name,int age,String department){
        super(name,age);
        this.department=department;
    }
    void displayRole(){
        displayPerson();
        System.out.println("Role:Staff");
        System.out.println("Department:"+department);
    }
}
public class SchoolTest{
    public static void main(String[] args){
        Person p1=new Teacher("Ramesh",40,"Maths");
        Person p2=new Student("Anita",18,"A");
        Person p3=new Staff("Suresh",45,"Administration");
        ((Teacher)p1).displayRole();
        ((Student)p2).displayRole();
        ((Staff)p3).displayRole();
    }
}