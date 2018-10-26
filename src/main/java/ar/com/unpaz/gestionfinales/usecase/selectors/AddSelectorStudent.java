package ar.com.unpaz.gestionfinales.usecase.selectors;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class AddSelectorStudent extends AbstractSelector<Student> {

  public AddSelectorStudent() {
    super(AppViewContext.addFinalDialog, 
          AppViewContext.addSelectStudentDialog);
  }

  @Override
  Final prepare(Final finalObj, Student entity) {
    return new Final(finalObj.getId(), finalObj.getSubject(), 
        entity, finalObj.getDate(),
        finalObj.getQualification());
  }

}
