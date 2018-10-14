package ar.com.unpaz.gestionfinales.jasper;

import ar.com.unpaz.gestionfinales.domain.Student;

public class StudentDataAdapter {

  private Student student;
  
  public StudentDataAdapter() {
    super();
  }
  
  public StudentDataAdapter(Student student) {
    this.student = student;
  }
  
  public String getId() {
    return String.valueOf(student.getId());
  }
  
  public String getName() {
    return student.getName();
  }
  
  public String getSurname() {
    return student.getSurname();
  }
  
  public String getEmail() {
    return student.getEmail();
  }
  
}
