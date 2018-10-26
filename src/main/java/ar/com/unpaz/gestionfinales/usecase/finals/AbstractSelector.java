package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.Select;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public abstract class AbstractSelector<E, Final> implements DialogController {

  private Select<E> selector;
  private Dialog<Final> dialog;

  public AbstractSelector(Select<E> selector, Dialog<Final> dialog) {
    this.selector = selector;
    this.dialog = dialog;
  }

  @Override
  public void accept() {
    if (selector.getSelectedRow() != -1) {
      int row = selector.getSelectedRow();
      E studentOrSubject = selector.getInRow(row);
      Final finalObj = dialog.get();
      dialog.set(prepare(finalObj, studentOrSubject));
      selector.close();
    }
  }

  abstract Final prepare(Final finalObj, E entity);

  @Override
  public void cancel() {
    selector.close();
  }

}
