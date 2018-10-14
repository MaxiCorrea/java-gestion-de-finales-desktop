package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class UpdateSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.updSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.update(subject);
    AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.updSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.updSubjectDialog.close();
  }
  
}
