package ar.com.unpaz.gestionfinales.usecase.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.NullValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteStudentUseCase extends SkeletonStudentUseCase {

  public DeleteStudentUseCase() {
    this(new NullValidator<Student>());
  }

  public DeleteStudentUseCase(Validator<Student> validator) {
    super(validator);
  }

  @Override
  Student getTheStudentOfTheDialog() {
    return AppViewContext.delStudentDialog.get();
  }

  @Override
  void executeAction(Student student) {
    AppRepositoryContext.studentRepository.remove(student);
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.studentsView.set(all);
    AppViewContext.delStudentDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {}

  @Override
  void cancelAction() {
    AppViewContext.delStudentDialog.close();
  }

}
