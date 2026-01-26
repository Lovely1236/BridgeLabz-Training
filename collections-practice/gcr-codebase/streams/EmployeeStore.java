package streams;
import java.io.Serializable;
import java.io.*;
import java.util.*;
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id,String name,String department,double salary) {
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public String toString() {
        return id+" "+name+" "+department+" "+salary;
    }
}
public class EmployeeStore {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(1,"Lovely","IT",50000));
        list.add(new Employee(2,"Mahima","HR",45000));
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("output.txt"));
            oos.writeObject(list);
            oos.close();
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("output.txt"));
            List<Employee> employees=(List<Employee>)ois.readObject();
            for(Employee e:employees) {
                System.out.println(e);
            }
            ois.close();
        } catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}