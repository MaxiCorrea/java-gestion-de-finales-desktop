package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteSubjectDialogFake implements Dialog<Subject> {

  private boolean closed;
  private Subject selected;
  
  @Override
  public void set(Subject selected) {
    this.selected = selected;
  }

  @Override
  public void setController(DialogController controller) {}

  @Override
  public void show() {}

  @Override
  public Subject get() {
    return selected;
  }

  @Override
  public void close() {
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }

  @Override
  public void showError(String message) {
    // TODO Auto-generated method stub
    
  }
  
}
