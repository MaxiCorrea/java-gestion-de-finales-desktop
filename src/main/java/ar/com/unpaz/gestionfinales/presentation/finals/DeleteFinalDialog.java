package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface DeleteFinalDialog {

  void setFinal(Final finalObj);

  Final getFinal();

  void setController(DialogController controller);

  void show();

  void close();

}
