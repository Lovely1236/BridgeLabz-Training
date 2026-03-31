package StudentCourseRegistration;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Student[] students = {
        new Student(1, "Lovely"),
        new Student(2, "Palak"),
        new Student(3, "Mansi"),
        new Student(4, "Ritika")
    };
    Course[] course = {
        new Course(101, "Data Structures"),
        new Course(102, "Operating Systems"),
        new Course(103, "Database Management"),
        new Course(104, "Computer Networks")
    };

    List<Addition> ls = new ArrayList<>();

    for (Addition addition : ls) {
      System.out.println(
          "Student ID: " + addition.getStudent().getStudentId() +
              ", Student Name: " + addition.getStudent().getStudentName() +
              ", Course ID: " + addition.getCourse().getCoruseId() +
              ", Course Name: " + addition.getCourse().getCourseName());
    }

    while (true) {
      System.out.print(
          "Enter your choice -: 1 for display courses | 2 for add to course | 3 for drop course|4 for display all data | 5 for exit  -:");
      int choice = sc.nextInt();
      if (choice == 1) {
        for (Course course2 : course) {
          System.out.println("Course id -: " + course2.getCoruseId() + " Course Name -: " + course2.getCourseName());
        }
      } else if (choice == 2) {
        System.out.print("Enter the id of the course -: ");
        int id = sc.nextInt();

        Course selectedCourse = null;

        for (Course c : course) {
          if (c.getCoruseId() == id) {
            selectedCourse = c;
            break;
          }
        }

        if (selectedCourse == null) {
          System.out.println("Course not found");
          continue;
        }

        sc.nextLine();

        System.out.print("Enter the name of the student -: ");
        String nameStudent = sc.nextLine();

        System.out.print("Enter the id of the student -: ");
        int studentId = sc.nextInt();

        Student student = new Student(studentId, nameStudent);

        Addition add = new Addition(selectedCourse, student);
        ls.add(add);

        System.out.println("Student enrolled in course successfully!");
      } else if (choice == 3) {
        System.out.print("Enter the id of the student -: ");
        int n = sc.nextInt();
        boolean isFound = false;

        for (int i = 0; i < ls.size(); i++) {
          if (ls.get(i).getStudent().getStudentId() == n) {
            ls.remove(i);
            isFound = true;
            break;
          }
        }

        if (!isFound) {
          System.out.println("No such type of id ");
        }

      } else if (choice == 4) {
        for (Addition addition : ls) {
          System.out.println(
              "Student ID: " + addition.getStudent().getStudentId() +
                  ", Student Name: " + addition.getStudent().getStudentName() +
                  ", Course ID: " + addition.getCourse().getCoruseId() +
                  ", Course Name: " + addition.getCourse().getCourseName());
        }
      } else if (choice == 5) {
        System.out.println("Thanks for visit.......");
        break;
      } else {
        System.out.println("Invalid Input");
        break;
      }

    }

  }
}