package generics;

import java.util.*;
abstract class CourseType {
    String name;
    CourseType(String name){
        this.name=name;
    }
}
class ExamCourse extends CourseType {
    ExamCourse(String name){
        super(name);
    }
}
class AssignmentCourse extends CourseType {
    AssignmentCourse(String name){
        super(name);
    }
}
class ResearchCourse extends CourseType {
    ResearchCourse(String name){
        super(name);
    }
}
class Course<T extends CourseType> {
    List<T> courses=new ArrayList<>();
    public void addCourse(T course){
        courses.add(course);
    }
    public List<T> getCourses(){
        return courses;
    }
    public static void displayAll(List<? extends CourseType> list){
        System.out.println("Courses:");
        for(CourseType c:list){
            System.out.println("-> "+c.name);
        }
    }
}
public class UniversitySystem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Course<CourseType> system=new Course<>();
        System.out.print("Enter number of courses: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter course type(Exam/Assignment/Research): ");
            String type=sc.nextLine();
            System.out.print("Enter course name: ");
            String name=sc.nextLine();
            if(type.equalsIgnoreCase("Exam")){
                system.addCourse(new ExamCourse(name));
            }else if(type.equalsIgnoreCase("Assignment")){
                system.addCourse(new AssignmentCourse(name));
            }else if(type.equalsIgnoreCase("Research")){
                system.addCourse(new ResearchCourse(name));
            }
        }
        Course.displayAll(system.getCourses());
    }
}