package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validation.Validator;

public abstract class SkeletonStudentUseCase implements DialogController {

  private final Validator<Student> validator;
  
  public SkeletonStudentUseCase(Validator<Student> validator) {
    this.validator = validator;
  }
  
  @Override
  public void accept() {
    Student student = getTheStudentOfTheDialog();
    if(validator.isValid(student)) {
      executeAction(student);
    } else  {
      showErrorInTheDialog(validator.getErrorMessage());
    }
  }

  abstract Student getTheStudentOfTheDialog();

  abstract void executeAction(Student student);
  
  abstract void showErrorInTheDialog(String errorMessage);
  
  @Override
  public void cancel() {
    cancelAction();
  }

  abstract void cancelAction();

}
