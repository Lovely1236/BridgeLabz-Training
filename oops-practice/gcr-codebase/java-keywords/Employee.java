public class Employee{
  static String companyName;
  public String name;
  public String designation;
  final int id;

  // constructor
  Employee(String companyName, String name, String designation, int id){
    Employee.companyName = companyName;
    this.name = name;
    this.designation = designation;
    this.id = id;
  }

  // use static variable with the help of getter and setter
  public static String getCompanyName(){
    return companyName;
  }

  public void setCompanyName(String companyName){

    this.companyName = companyName;
  }


  // use instance of
  public static void displayTotalEmployees(Employee e){
    if (e instanceof Employee){
      System.out.println("Library: " + e.getCompanyName());
      System.out.println("Company Name: " + e.companyName + ", Name: " + e.name + ", ID: " + e.id);
    }
  }


  // calling from main method
  public static void main(String[] args){
    Employee b = new Employee("Microsoft", "Lovely", "Software Engineer", 2153);
    displayTotalEmployees(b);

  }

}