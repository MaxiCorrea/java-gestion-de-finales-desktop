package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validations.SubjectValidator;
import ar.com.unpaz.gestionfinales.validations.Validator;

public class UpdateSubjectUseCase implements DialogController {

  private final Validator<Subject> validator;

  public UpdateSubjectUseCase() {
    validator = new SubjectValidator();
  }

  public UpdateSubjectUseCase(Validator<Subject> validator) {
    this.validator = validator;
  }

  @Override
  public void accept() {
    Subject subject = AppViewContext.updSubjectDialog.getSubject();
    if(validator.isValid(subject)) {
      AppRepositoryContext.subjectRepository.update(subject);
      AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
      AppViewContext.updSubjectDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.updSubjectDialog.showError(errorMessage);
    }
  }

  @Override
  public void cancel() {
    AppViewContext.updSubjectDialog.close();
  }

}
