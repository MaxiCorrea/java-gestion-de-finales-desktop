package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.Dialog;

public interface FinalDialog<E> extends Dialog<E> {

  void setStudent(Student student);

  void setSubject(Subject subject);

}
