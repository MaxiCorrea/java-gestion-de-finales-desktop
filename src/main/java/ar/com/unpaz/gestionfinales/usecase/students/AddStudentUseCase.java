package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.StudentValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddStudentUseCase extends SkeletonUseCase<Student> {

  public AddStudentUseCase() {
    this(new StudentValidator());
  }

  public AddStudentUseCase(Validator<Student> validator) {
    super(validator,
        AppViewContext.studentsView ,
        AppViewContext.addStudentDialog ,
        AppRepositoryContext.studentRepository);
  }

  @Override
  public void execute(Student entity) {
    AppRepositoryContext.studentRepository.add(entity);
  }

}
