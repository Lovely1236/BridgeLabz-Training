package StudentCourseRegistration;

class Course {
  private int coruseId;
  private String courseName;

  Course(int coruseId, String courseName) {
    this.coruseId = coruseId;
    this.courseName = courseName;
  }

  public int getCoruseId() {
    return coruseId;
  }

  public String getCourseName() {
    return courseName;
  }

}