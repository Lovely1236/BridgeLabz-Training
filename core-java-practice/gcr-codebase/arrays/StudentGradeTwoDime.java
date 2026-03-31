import java.util.*;

public class StudentGradeTwoDime {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    System.out.print("Enter number of students: ");
    int n = sc.nextInt();
    // make a 2d array to store the input
    int[][] marks = new int[n][3];
    double[] percentages = new double[n];
    char[] grades = new char[n];
    for (int i = 0; i < n; i++) {
      System.out.println("\nEnter marks for Student " + (i + 1) + ":");
      for (int j = 0; j < 3; j++) {
        String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
        System.out.print(subject + ": ");
        int mark = sc.nextInt();
        if (mark < 0) {
          System.out.println("Invalid input. Enter positive value.");
          j--;
        } else {
          marks[i][j] = mark;
        }
      }
    }

    // get the total grades and percentage
    for (int i = 0; i < n; i++) {
      int total = marks[i][0] + marks[i][1] + marks[i][2];
      percentages[i] = total / 3.0;

      double p = percentages[i];
      if (p >= 80)
        grades[i] = 'A';
      else if (p >= 70)
        grades[i] = 'B';
      else if (p >= 60)
        grades[i] = 'C';
      else if (p >= 50)
        grades[i] = 'D';
      else if (p >= 40)
        grades[i] = 'E';
      else
        grades[i] = 'R';
    }

    // print the student report
    System.out.println("\n--- Students Report ---");
    for (int i = 0; i < n; i++) {
      System.out.println("Student " + (i + 1) + ":");
      System.out.println("  Physics: " + marks[i][0]);
      System.out.println("  Chemistry: " + marks[i][1]);
      System.out.println("  Maths: " + marks[i][2]);
      System.out.printf("  Percentage: %.2f%%\n", percentages[i]);
      System.out.println("  Grade: " + grades[i]);
      System.out.println();
    }
  }
}