package ar.com.unpaz.gestionfinales.presentation.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.students.StudentsView;

public class StudentViewFake implements StudentsView {

  private List<Student> students;
  
  @Override
  public int getSelectedRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Student getStudentInRow(int row) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setStudents(List<Student> all) {
    this.students = all;
  }

  public List<Student> getStudents() {
    return students;
  }
  
  @Override
  public void show() {
    
  }

}
