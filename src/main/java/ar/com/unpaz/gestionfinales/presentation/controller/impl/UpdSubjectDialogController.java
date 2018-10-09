package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;

public class UpdSubjectDialogController implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.updSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.updateSubject(subject);
    AppViewContext.subjectView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.updSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.updSubjectDialog.close();
  }
  
}
