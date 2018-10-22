package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.AddSubjectDialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddSubjectDialogFake implements AddSubjectDialog {

  private boolean closeCalled;
  private String errorMessageDisplayed;
  private Subject subject;
  
  @Override
  public void setController(DialogController controller) {}

  @Override
  public void show() {}

  @Override
  public void close() {
    closeCalled = true;
  }

  public boolean isClosed() {
    return closeCalled;
  }
  
  @Override
  public Subject getSubject() {
    return subject;
  }

  @Override
  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  @Override
  public void showError(String message) {
    errorMessageDisplayed = message;
  }

  public String getErrorMessageDisplayed() {
    return errorMessageDisplayed;
  }
  
}

