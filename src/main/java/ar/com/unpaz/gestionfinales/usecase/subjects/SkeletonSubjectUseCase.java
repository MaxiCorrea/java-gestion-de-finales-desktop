package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validation.Validator;

public abstract class SkeletonSubjectUseCase implements DialogController {

  private final Validator<Subject> validator;

  public SkeletonSubjectUseCase(Validator<Subject> validator) {
    this.validator = validator;
  }

  @Override
  public void accept() {
    Subject subject = getTheSubjectOfTheDialog();
    if (validator.isValid(subject)) {
      executeAction(subject);
    } else {
      showErrorInTheDialog(validator.getErrorMessage());
    }
  }

  abstract Subject getTheSubjectOfTheDialog();

  abstract void executeAction(Subject subject);

  abstract void showErrorInTheDialog(String errorMessage);

  @Override
  public void cancel() {
    cancelAction();
  }

  abstract void cancelAction();

}