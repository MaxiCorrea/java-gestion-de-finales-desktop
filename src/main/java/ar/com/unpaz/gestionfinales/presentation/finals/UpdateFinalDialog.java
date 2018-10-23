package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.FinalDialogController;

public interface UpdateFinalDialog {

  void setFinal(Final finalObj);

  Final getFinal();

  void setController(FinalDialogController controller);

  void show();

  void close();

  void showError(String errorMessage);

  void setStudent(Student student);

  void setSubject(Subject subject);

}
