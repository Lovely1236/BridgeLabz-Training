package StudentCourseRegistration;

class Addition {
  private Course course;
  private Student student;

  Addition(Course course, Student student) {
    this.course = course;
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public Student getStudent() {
    return student;
  }

}