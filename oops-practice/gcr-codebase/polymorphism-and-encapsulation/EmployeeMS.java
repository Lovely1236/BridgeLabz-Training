abstract class Employee{
    String employeeId;
    String name;
    int baseSalary;
    Employee(String employeeId,String name ,int baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
        
    }
    public void setSalary(){
        this.baseSalary=baseSalary;
        
    }
    public int getSalary(){
        return baseSalary;
    }
      public void setname(){
        this.name=name;
        
    }
    public String getemployeeId(){
        return employeeId;
    }
      public void setemployeeId(){
        this.employeeId=employeeId;
        
    }
    public String getname(){
        return name;
    }
    
   abstract  int calculateSalary();
   void displayDetails(){
       System.out.println("Employee details is:"+employeeId);
       System.out.println("The name of the employee is :"+name);
   }
     
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String employeeId,String name ,int baseSalary){
         super( employeeId, name , baseSalary);
    }

    int calculateSalary(){
        System.out.print("The full time salary is:");

        return baseSalary;
    }
    
}
class PartTimeEmployee extends Employee {
    int hours;int hourlyPrice;
    PartTimeEmployee(String employeeId,String name,int hours,int hourlyPrice){
         super( employeeId, name ,0);
         this.hours=hours;
          this.hourlyPrice=hourlyPrice;
    }
    int calculateSalary(){
        System.out.print("The part time salary is:");
        return hourlyPrice*hours;
    }
}
public class EmployeeMS
{

	public static void main(String[] args) {
	    Employee e=new FullTimeEmployee("f843u7GFFWHIU","Mahima Mishra",2000);
	   System.out.println (e.calculateSalary());
	   Employee e1=new PartTimeEmployee("b86rvj9","Garima Mishra",4,1000);
	   System.out.println(e1.calculateSalary());
	   e.displayDetails();
	   	   e1.displayDetails();

	   
	}
}