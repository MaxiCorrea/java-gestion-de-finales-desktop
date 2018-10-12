package ar.com.unpaz.gestionfinales.presentation.view;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.controller.FinalDialogController;

public interface UpdateFinalDialog {

  void setFinal(Final finalObj);

  Final getFinal();

  void setController(FinalDialogController controller);

  void show();

  void close();

}
