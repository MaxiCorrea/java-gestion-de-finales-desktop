package ar.com.unpaz.gestionfinales.usecase;

import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.View;

public class SkeletonUseCases<E> implements UseCases<E> {

  private final Dialog<E> addDialog;
  private final Dialog<E> delDialog;
  private final Dialog<E> updDialog;
  private final Dialog<E> repDialog;
  private final View<E> view;

  public SkeletonUseCases(Dialog<E> addDialog, 
                          Dialog<E> delDialog, 
                          Dialog<E> updDialog,
                          Dialog<E> repDialog,
                          View<E> view) {
    
    this.addDialog = addDialog;
    this.delDialog = delDialog;
    this.updDialog = updDialog;
    this.repDialog = repDialog;
    this.view = view;
  }

  @Override
  public void add() {
    addDialog.showError("");
    addDialog.show();
  }

  @Override
  public void delete() {
    if(view.getSelectedRow() != -1) {
      int row = view.getSelectedRow();
      E entity = view.getInRow(row);
      delDialog.set(entity);
      delDialog.showError("");
      delDialog.show();
    }
  }

  @Override
  public void update() {
    if(view.getSelectedRow() != -1) {
      int row = view.getSelectedRow();
      E entity = view.getInRow(row);
      updDialog.set(entity);
      updDialog.showError("");
      updDialog.show();
    }
  }

  @Override
  public void report() {
    repDialog.show();
  }

}
