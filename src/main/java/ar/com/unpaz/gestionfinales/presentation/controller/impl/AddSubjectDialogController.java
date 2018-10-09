package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;

public class AddSubjectDialogController implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.addSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.addSubject(subject);
    AppViewContext.subjectView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.addSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.addSubjectDialog.close();
  }
  
}
