package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;

public class DelSubjectDialogController implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.delSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.removeSubject(subject);
    AppViewContext.subjectView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.delSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.delSubjectDialog.close();
  }
  
}
