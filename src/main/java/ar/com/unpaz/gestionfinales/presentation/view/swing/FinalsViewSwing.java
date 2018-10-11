package ar.com.unpaz.gestionfinales.presentation.view.swing;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.view.FinalsView;

public class FinalsViewSwing implements FinalsView {

  @Override
  public int getSelectedRow() {
    return 0;
  }

  @Override
  public Final getFinalInRow(int row) {
    return null;
  }

  @Override
  public void setFinals(List<Final> finals) {
    
  }

  @Override
  public void show() {
    
  }

}
