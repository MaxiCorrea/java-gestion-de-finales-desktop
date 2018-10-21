package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validations.SubjectValidator;
import ar.com.unpaz.gestionfinales.validations.Validator;

public class AddSubjectUseCase implements DialogController {

  private final Validator<Subject> validator;

  public AddSubjectUseCase() {
    validator = new SubjectValidator();
  }

  public AddSubjectUseCase(Validator<Subject> validator) {
    this.validator = validator;
  }

  @Override
  public void accept() {
    Subject subject = AppViewContext.addSubjectDialog.getSubject();
    if (validator.isValid(subject)) {
      AppRepositoryContext.subjectRepository.add(subject);
      AppViewContext.subjectsView.setSubjects(AppRepositoryContext.subjectRepository.getAll());
      AppViewContext.addSubjectDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.addSubjectDialog.showError(errorMessage);
    }
  }

  @Override
  public void cancel() {
    AppViewContext.addSubjectDialog.close();
  }

}
