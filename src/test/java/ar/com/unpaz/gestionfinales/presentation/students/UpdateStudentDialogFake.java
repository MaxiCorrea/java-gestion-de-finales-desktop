package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.UpdateDialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class UpdateStudentDialogFake implements UpdateDialog<Student> {

  private Student student;
  private boolean closed;
  private String errorMessageDisplayed;

  @Override
  public void setController(DialogController controller) {}

  @Override
  public void set(Student selected) {
    this.student = selected;
  }

  @Override
  public Student get() {
    return student;
  }

  @Override
  public void show() {}

  @Override
  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }

  @Override
  public void showError(String message) {
    errorMessageDisplayed = message;
  }

  public Object getErrorDisplayed() {
    return errorMessageDisplayed;
  }

}
