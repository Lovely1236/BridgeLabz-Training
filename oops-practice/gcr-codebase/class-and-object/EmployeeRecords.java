class EmployeeRecord{
    public int employeeID;
    protected String department;
    private double salary;
    public Employee(int employeeID, String department, double salary){

        
        // Constructor
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }


    // Public method to modify salary
    public void setSalary(double salary){
         this.salary = salary;


    }



    public double getSalary(){
        return salary;


    }
}


class Manager extends Employee{
    public Manager(int employeeID, String department, double salary){
        super(employeeID, department, salary);
    }



    public void displayEmployeeDetails(){
        System.out.println("Employee ID: " + employeeID); // public
        System.out.println("Department: " + department);  // protected
        System.out.println("Salary: ₹" + getSalary());    // private via method
    }
}
