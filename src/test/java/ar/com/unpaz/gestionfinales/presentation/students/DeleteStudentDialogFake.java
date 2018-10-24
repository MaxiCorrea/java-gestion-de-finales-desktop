package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteStudentDialogFake implements Dialog<Student> {

  private Student student;
  private boolean closed;
  
  @Override
  public void setController(DialogController controller) {}

  @Override
  public void set(Student selected) {
    this.student = selected;
  }

  @Override
  public void show() {
    
  }

  @Override
  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }
  
  @Override
  public Student get() {
    return student;
  }

  @Override
  public void showError(String message) {
    // TODO Auto-generated method stub
    
  }

}
