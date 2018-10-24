package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.NullValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteStudentUseCase extends SkeletonUseCase<Student> {

  public DeleteStudentUseCase() {
    this(new NullValidator<>());
  }

  public DeleteStudentUseCase(Validator<Student> validator) {
    super(validator,
        AppViewContext.studentsView ,
        AppViewContext.delStudentDialog ,
        AppRepositoryContext.studentRepository);
  }

  @Override
  public void execute(Student entity) {
    AppRepositoryContext.studentRepository.remove(entity);
  }

}
