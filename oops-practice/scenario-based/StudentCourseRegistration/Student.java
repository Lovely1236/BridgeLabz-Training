package StudentCourseRegistration;

class Student {
  private int studentId;
  private String studentName;

  Student(int studentId, String studentName) {
    this.studentId = studentId;
    this.studentName = studentName;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getStudentName() {
    return studentName;
  }
}