package ar.com.unpaz.gestionfinales.usecase.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddStudentUseCase extends SkeletonStudentUseCase {

  public AddStudentUseCase() {
    super(new StudentValidator());
  }

  public AddStudentUseCase(Validator<Student> validator) {
    super(validator);
  }

  @Override
  Student getTheStudentOfTheDialog() {
    return AppViewContext.addStudentDialog.get();
  }

  @Override
  void executeAction(Student student) {
    AppRepositoryContext.studentRepository.add(student);
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.studentsView.set(all);
    AppViewContext.addStudentDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {
    AppViewContext.addStudentDialog.showError(errorMessage);
  }

  @Override
  void cancelAction() {
    AppViewContext.addStudentDialog.close();
  }

}
