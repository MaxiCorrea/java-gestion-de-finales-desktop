package ar.com.unpaz.gestionfinales.presentation.view;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Final;

public interface FinalsView {

  int getSelectedRow();

  Final getFinalInRow(int row);

  void setFinals(List<Final> finals);

  void show();

}
