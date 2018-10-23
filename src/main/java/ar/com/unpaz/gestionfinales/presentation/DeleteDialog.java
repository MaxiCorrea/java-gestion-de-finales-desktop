package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface DeleteDialog<E> extends Dialog {

  void setController(DialogController controller);

  void set(E e);

  E get();

}
