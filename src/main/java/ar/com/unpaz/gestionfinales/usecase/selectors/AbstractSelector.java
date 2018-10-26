package ar.com.unpaz.gestionfinales.usecase.selectors;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.Select;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public abstract class AbstractSelector<E> implements DialogController {

  private final Dialog<Final> dialog;
  private final Select<E> selector;
  
  public AbstractSelector(Dialog<Final> dialog , Select<E> selector) {
    this.dialog = dialog;
    this.selector = selector;
  }

  @Override
  public void accept() {
    if(selector.getSelectedRow() != -1) {
      int rowIndex = selector.getSelectedRow();
      E entity = selector.getInRow(rowIndex);
      Final finalObj = dialog.get();
      dialog.set(prepare(finalObj , entity));
      selector.close();
    }
  }

  abstract Final prepare(Final finalObj, E entity);

  @Override
  public void cancel() {
    selector.close();
  }
 
}
