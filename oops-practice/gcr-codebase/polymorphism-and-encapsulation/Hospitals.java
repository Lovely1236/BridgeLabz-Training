// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    // Sensitive data (Encapsulation)
    private String diagnosis;
    private String medicalHistory;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters only
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Protected access for subclasses
    protected void setMedicalData(String diagnosis, String history) {
        this.diagnosis = diagnosis;
        this.medicalHistory = history;
    }

    protected String getMedicalData() {
        return "Diagnosis: " + diagnosis + ", History: " + medicalHistory;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method
    abstract double calculateBill();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;
    private String record;

    InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        setMedicalData("Serious Condition", "Admitted in hospital");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
        System.out.println(getMedicalData());
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private String record;

    OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
        setMedicalData("Minor Illness", "OPD Visit");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
        System.out.println(getMedicalData());
    }
}

// Main class
public class Hospital {

    public static void main(String[] args) {

        // Polymorphism
        Patient p1 = new InPatient(101, "Rahul", 45, 4, 2000);
        Patient p2 = new OutPatient(102, "Anita", 30, 500);

        processPatient(p1);
        processPatient(p2);
    }

    // Single method handling different patient types
    static void processPatient(Patient patient) {

        patient.getPatientDetails();
        System.out.println("Bill Amount: ₹" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            MedicalRecord m = (MedicalRecord) patient;
            m.addRecord("Treatment provided successfully");
            m.viewRecords();
        }

        System.out.println("-----------------------------------");
    }
}