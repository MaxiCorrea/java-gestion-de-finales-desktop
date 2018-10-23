package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.FinalDialogController;

public interface AddFinalDialog {

  void setFinal(Final finalObj);
  
  Final getFinal();
  
  void setController(FinalDialogController controller);
  
  void show();
  
  void close();

  void setSubject(Subject subject);

  void setStudent(Student student);

  void showError(String errorMessage);
  
}
