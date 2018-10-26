package ar.com.unpaz.gestionfinales.usecase.finals;

import java.time.LocalDate;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.Select;

public class SubjectSelection extends AbstractSelector<Subject, Final> {

  public SubjectSelection() {
    super(AppViewContext.addSelectSubjectDialog, AppViewContext.addFinalDialog);
  }

  public SubjectSelection(Select<Subject> selector, Dialog<Final> dialog) {
    super(selector, dialog);
  }

  @Override
  Final prepare(Final finalObj, Subject entity) {
    int id = finalObj.getId();
    Student student = finalObj.getStudent();
    LocalDate date = finalObj.getDate();
    Qualification qa = finalObj.getQualification();
    return new Final(id, entity, student, date, qa);
  }
}