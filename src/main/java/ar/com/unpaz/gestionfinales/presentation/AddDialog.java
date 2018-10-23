package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface AddDialog<E> extends Dialog {

  void setController(DialogController controller);

  E get();

  void set(E e);

  void showError(String message);
}
