package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.application.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.application.AppViewContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.addSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.add(subject);
    AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.addSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.addSubjectDialog.close();
  }
  
}
