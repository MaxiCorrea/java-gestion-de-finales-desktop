package ar.com.unpaz.gestionfinales.usecase.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.NoStudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteStudentUseCase extends SkeletonStudentUseCase {

  public DeleteStudentUseCase() {
    this(new NoStudentValidator());
  }

  public DeleteStudentUseCase(Validator<Student> validator) {
    super(validator);
  }

  @Override
  Student getTheStudentOfTheDialog() {
    return AppViewContext.delStudentDialog.getStudent();
  }

  @Override
  void executeAction(Student student) {
    AppRepositoryContext.studentRepository.remove(student);
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.studentsView.setStudents(all);
    AppViewContext.delStudentDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {}

  @Override
  void cancelAction() {
    AppViewContext.delStudentDialog.close();
  }

}
