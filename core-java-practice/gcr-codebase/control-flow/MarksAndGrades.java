import java.util.*;
public class MarksAndGrades {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int phy, chem, maths;
        float percentage = phy+chem+maths /3;

         Char grade;
        String remarks;
    
        // Grade calculation
        if (average >= 80) {
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        } else if (average >= 60) {
            grade = 'C';
            remarks = "Level 2, below but approaching agency-normalized standards";
        } else if (average >= 50) {
            grade = 'D';
            remarks = "Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            grade = 'E';
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = 'R';
            remarks = "Remedial standards";
        }

        // Output
        System.out.println("\n--- Result ---");
        System.out.println("Average Marks: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

    } 
}
