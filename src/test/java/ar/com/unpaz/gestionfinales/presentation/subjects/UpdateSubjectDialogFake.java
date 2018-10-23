package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.UpdateDialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class UpdateSubjectDialogFake implements UpdateDialog<Subject> {

  private boolean closed;
  private Subject subject;
  private String errorDisplayed;
  
  @Override
  public void set(Subject selected) {
    subject = selected;
  }

  @Override
  public void setController(DialogController controller) {}

  @Override
  public void show() {
    
  }

  @Override
  public void close() {
    closed = true;
  }

  @Override
  public Subject get() {
    return subject;
  }

  @Override
  public void showError(String message) {
    errorDisplayed = message;
  }

  public String getErrorDisplayed() {
    return errorDisplayed;
  }
  
  public boolean isClosed() {
    return closed;
  }

}
