package ar.com.unpaz.gestionfinales.usecase.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateStudentUseCase extends SkeletonStudentUseCase {

  public UpdateStudentUseCase() {
    this(new StudentValidator());
  }

  public UpdateStudentUseCase(Validator<Student> validator) {
    super(validator);
  }

  @Override
  Student getTheStudentOfTheDialog() {
    return AppViewContext.updStudentDialog.get();
  }

  @Override
  void executeAction(Student student) {
    AppRepositoryContext.studentRepository.update(student);
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.studentsView.set(all);
    AppViewContext.updStudentDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {
    AppViewContext.updStudentDialog.showError(errorMessage);
  }

  @Override
  void cancelAction() {
    AppViewContext.updStudentDialog.close();
  }

}

