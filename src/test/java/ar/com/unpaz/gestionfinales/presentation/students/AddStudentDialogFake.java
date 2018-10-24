package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddStudentDialogFake implements Dialog<Student> {

  private Student student;
  private boolean closed;
  private String errorMessage;
  
  @Override
  public void setController(DialogController controller) {}

  @Override
  public void show() {}

  @Override
  public void set(Student student) {
    this.student = student;
  }

  @Override
  public Student get() {
    return student;
  }

  @Override
  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }
  
  @Override
  public void showError(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public String getErrorMessageDisplayed() {
    return errorMessage;
  }

}
