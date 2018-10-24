package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateStudentUseCase extends SkeletonUseCase<Student> {

  public UpdateStudentUseCase() {
    this(new StudentValidator());
  }

  public UpdateStudentUseCase(Validator<Student> validator) {
    super(validator,
        AppViewContext.studentsView ,
        AppViewContext.updStudentDialog ,
        AppRepositoryContext.studentRepository);
  }

  @Override
  public void execute(Student entity) {
    AppRepositoryContext.studentRepository.update(entity);
  }

}

