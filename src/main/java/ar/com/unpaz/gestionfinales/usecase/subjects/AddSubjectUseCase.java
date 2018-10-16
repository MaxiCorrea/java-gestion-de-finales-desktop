package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    Subject subject = AppViewContext.addSubjectDialog.getSubject();
    String errorMessage = Subject.validateFieldsOf(subject);
    if (!errorMessage.isEmpty()) {
      AppViewContext.addSubjectDialog.showError(errorMessage);
    } else {
      AppRepositoryContext.subjectRepository.add(subject);
      AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
      AppViewContext.addSubjectDialog.close();
    }
  }

  @Override
  public void cancel() {
    AppViewContext.addSubjectDialog.close();
  }

}
