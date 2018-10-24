package ar.com.unpaz.gestionfinales.presentation.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class SelectStudentDialogFake implements SelectStudentDialog {

  @Override
  public void setController(DialogController controller) {
    // TODO Auto-generated method stub
    
  }

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
  public void set(List<Student> students) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub
    
  }

}
