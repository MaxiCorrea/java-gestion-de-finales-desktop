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
    if(student == null) {
      return "";
    }
    return student.getDni();
  }
  
  public String getName() {
    if(student == null) {
      return "";
    }
    return student.getName();
  }
  
  public String getSurname() {
    if(student == null) {
      return "";
    }
    return student.getSurname();
  }
  
  public String getEmail() {
    if(student == null) {
      return "";
    }
    return student.getEmail();
  }
  
}
