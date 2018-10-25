package ar.com.unpaz.gestionfinales.presentation;

import java.util.List;

public class ViewFake<E> implements View<E> {

  private List<E> all;
  private boolean showing;
  
  @Override
  public int getSelectedRow() {
    return 0;
  }

  @Override
  public E getInRow(int row) {
    return null;
  }

  @Override
  public void set(List<E> all) {
    this.all = all;
  }

  public List<E> getAll() {
    return all;
  }
  
  @Override
  public void show() {
    showing = true;
  }

  public boolean isShowing() {
    return showing;
  }
  
}
