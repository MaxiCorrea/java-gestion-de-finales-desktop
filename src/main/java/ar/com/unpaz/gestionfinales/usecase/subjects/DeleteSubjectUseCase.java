package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.delSubjectDialog.getSubject();
    AppRepositoryContext.subjectRepository.remove(subject);
    AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.delSubjectDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.delSubjectDialog.close();
  }
  
}
