package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateStudentUseCase implements DialogController {

  private final Validator<Student> validator;

  public UpdateStudentUseCase() {
    validator = new StudentValidator();
  }

  public UpdateStudentUseCase(Validator<Student> validator) {
    this.validator = validator;
  }

  @Override
  public void accept() {
    Student student = AppViewContext.updStudentDialog.getStudent();
    if (validator.isValid(student)) {
      AppRepositoryContext.studentRepository.update(student);
      AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
      AppViewContext.updStudentDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.updStudentDialog.showError(errorMessage);
    }

  }

  @Override
  public void cancel() {
    AppViewContext.updStudentDialog.close();
  }

}

