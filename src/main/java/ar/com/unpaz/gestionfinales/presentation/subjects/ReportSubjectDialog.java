package ar.com.unpaz.gestionfinales.presentation.subjects;

import java.io.File;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface ReportSubjectDialog {

  void setController(DialogController controller);

  void show();

  File getFile();

  void close();

}
