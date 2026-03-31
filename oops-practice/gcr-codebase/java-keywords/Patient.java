public class Patient{
    //static variable shared by all patients
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    //final variable
    private final String patientID;
    //instance variables
    private String name;
    private int age;
    private String ailment;
    //constructor using 'this'


    public Patient(String patientID, String name, int age, String ailment){
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }


    //static method
    public static void getTotalPatients(){
        System.out.println("Total Patients Admitted: " + totalPatients);

    }
    //display details using instanceof
    public void displayPatientDetails(){
        if(this instanceof Patient){
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }


    //main method
    public static void main(String[] args){
        Patient patient1 = new Patient("P001", "Laa", 30, "stomach pain");
        Patient patient2 = new Patient("P002", "Liya", 45, "Fever");
        getTotalPatients();
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
    }
}
