package ar.com.unpaz.gestionfinales.usecase.selectors;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class UpdSeletorSubject extends AbstractSelector<Subject> {

  public UpdSeletorSubject() {
    super(AppViewContext.updFinalDialog, 
          AppViewContext.updSelectSubjectDialog);
  }

  @Override
  Final prepare(Final finalObj, Subject entity) {
    return new Final(finalObj.getId(), entity, 
        finalObj.getStudent(), finalObj.getDate(),
        finalObj.getQualification());
  }

}
