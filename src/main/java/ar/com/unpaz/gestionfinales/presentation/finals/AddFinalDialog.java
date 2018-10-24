package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.Dialog;

public interface AddFinalDialog extends Dialog<Final> {

  void setSubject(Subject subject);

  void setStudent(Student student);

}
