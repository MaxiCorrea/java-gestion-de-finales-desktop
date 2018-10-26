package ar.com.unpaz.gestionfinales.usecase.finals;

import java.time.LocalDate;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.Select;

public class StudentSelection extends AbstractSelector<Student, Final> {

  public StudentSelection() {
    super(AppViewContext.addSelectStudentDialog, AppViewContext.addFinalDialog);
  }

  public StudentSelection(Select<Student> selector, Dialog<Final> dialog) {
    super(selector, dialog);
  }

  @Override
  Final prepare(Final finalObj, Student entity) {
    int id = finalObj.getId();
    Subject subject = finalObj.getSubject();
    LocalDate date = finalObj.getDate();
    Qualification qa = finalObj.getQualification();
    return new Final(id, subject, entity, date, qa);
  }

}
