package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface DeleteSubjectDialog {

  void setSubject(Subject selected);

  void setController(DialogController controller);

  void show();

  Subject getSubject();

  void close();

}
