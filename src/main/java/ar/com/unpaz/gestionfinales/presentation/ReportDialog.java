package ar.com.unpaz.gestionfinales.presentation;

import java.io.File;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface ReportDialog {

  void setController(DialogController controller);

  void show();

  File getFile();

  void close();

}
