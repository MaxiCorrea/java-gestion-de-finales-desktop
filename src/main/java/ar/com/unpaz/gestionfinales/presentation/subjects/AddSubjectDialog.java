package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface AddSubjectDialog {

  void setController(DialogController controller);

  void show();

  void close();

  Subject getSubject();

  void setSubject(Subject subject);
  
}
