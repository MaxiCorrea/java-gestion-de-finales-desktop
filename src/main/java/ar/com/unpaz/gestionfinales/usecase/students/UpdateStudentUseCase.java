package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class UpdateStudentUseCase implements DialogController {

  @Override
  public void accept() {
    Student student = AppViewContext.updStudentDialog.getStudent();
    AppRepositoryContext.studentRepository.update(student);
    AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
    AppViewContext.updStudentDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.updStudentDialog.close();
  }

}

