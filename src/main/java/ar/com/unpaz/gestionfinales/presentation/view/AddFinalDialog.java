package ar.com.unpaz.gestionfinales.presentation.view;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.FinalDialogController;

public interface AddFinalDialog {

  void setFinal(Final finalObj);
  
  Final getFinal();
  
  void setController(FinalDialogController controller);
  
  void show();
  
  void close();

  void setSubject(Subject subject);

  void setStudent(Student student);
  
}
