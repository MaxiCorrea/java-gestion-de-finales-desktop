package ar.com.unpaz.gestionfinales.usecase.selectors;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class AddSelectorSubject extends AbstractSelector<Subject> {

  public AddSelectorSubject() {
    super(AppViewContext.addFinalDialog, 
          AppViewContext.addSelectSubjectDialog);
  }

  @Override
  Final prepare(Final finalObj, Subject entity) {
    return new Final(finalObj.getId(), entity, 
        finalObj.getStudent(), finalObj.getDate(),
        finalObj.getQualification());
  }

}
