package ar.com.unpaz.gestionfinales.presentation.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.View;

public class StudentViewFake implements View<Student> {

  private List<Student> students;
  
  @Override
  public int getSelectedRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Student getInRow(int row) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void set(List<Student> all) {
    this.students = all;
  }

  public List<Student> getStudents() {
    return students;
  }
  
  @Override
  public void show() {
    
  }

}
