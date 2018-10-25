package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DialogFake<E> implements Dialog<E> {

  private String errorMessage;
  private boolean showing;
  private boolean closed;
  private E entity;

  @Override
  public void setController(DialogController controller) {}

  @Override
  public void showError(String message) {
    errorMessage = message;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  @Override
  public E get() {
    return entity;
  }

  @Override
  public void set(E e) {
    this.entity = e;
  }

  @Override
  public void show() {
    showing = true;
    closed = false;
  }

  public boolean isShowing() {
    return showing;
  }

  @Override
  public void close() {
    showing = false;
    closed = true;
  }

  public boolean isClosed() {
    return closed;
  }

}
