class Student{
    public int rollNumber;
    protected String name;
    private double cgpa;


    // Constructor
 public Student(int rollNumber, String name, double cgpa){
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }


    // Public methods to access & modify CGPA
    public double getCGPA(){
        
        return cgpa;
    }


    public void setCGPA(double cgpa){
       
        this.cgpa = cgpa;
    }
}


class PostgraduateStudent extends Student{
    public PostgraduateStudent(int rollNumber, String name, double cgpa){
        super(rollNumber, name, cgpa);

    }
     public void displayDetails(){
        System.out.println("Roll Number of Student is : " + rollNumber); // public
        System.out.println("Name of Student is : " + name);               // protected
        System.out.println("CGPA of Student is : " + getCGPA());           // private via method

    }
}
