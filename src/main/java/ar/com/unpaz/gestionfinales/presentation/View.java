package ar.com.unpaz.gestionfinales.presentation;

import java.util.List;

public interface View<E> {

  int getSelectedRow();

  E getInRow(int row);

  void set(List<E> all);

  void show();
  
}
