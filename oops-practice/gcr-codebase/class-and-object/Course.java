public class Course{

  // instance variable
  String courseName;
  int duration;
  int fee;

  // class variable
  static String instituteName = "GLA UNIVERSITY, MATHURA";


  // instance method
  void displayCourseDetails(){
    System.out.println("Course Name -: " + courseName);
    System.out.println("Course Duration -: " + duration);
    System.out.println("Course Fee -: " + fee);
  }

  // class method
  static void updateInstitueName(){
    System.out.println("Institute name is -: " + instituteName);
  }

  public static void main(String[] args){
    Course c = new Course();
    c.courseName = "B.Tech";
    c.duration = 3;
    c.fee = 1200000;

    Course.updateInstitueName();

  }

}