package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface Dialog<E> {

  void setController(DialogController controller);

  void showError(String message);

  E get();

  void set(E e);
  
  void show();

  void close();

}
