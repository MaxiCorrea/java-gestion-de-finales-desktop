package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddStudentUseCase implements DialogController {

  private final Validator<Student> validator;
  
  public AddStudentUseCase() {
    validator = new StudentValidator();
  }
  
  public AddStudentUseCase(Validator<Student> validator) {
    this.validator = validator;
  }
  
  @Override
  public void accept() {
    Student student = AppViewContext.addStudentDialog.getStudent();
    if(validator.isValid(student)) {
      AppRepositoryContext.studentRepository.add(student);
      AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
      AppViewContext.addStudentDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.addStudentDialog.showError(errorMessage);
    }
  }
  
  @Override
  public void cancel() {
    AppViewContext.addStudentDialog.close();
  }

}
