package ar.com.unpaz.gestionfinales.usecase.selectors;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class UpdSelectorStudent extends AbstractSelector<Student> {

  public UpdSelectorStudent() {
    super(AppViewContext.updFinalDialog, 
          AppViewContext.updSelectStudentDialog);
  }

  @Override
  Final prepare(Final finalObj, Student entity) {
    return new Final(finalObj.getId(), finalObj.getSubject(), 
        entity, finalObj.getDate(),
        finalObj.getQualification());
  }

}
