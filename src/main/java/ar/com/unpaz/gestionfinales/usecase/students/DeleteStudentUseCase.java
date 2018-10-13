package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.application.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.application.AppViewContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteStudentUseCase implements DialogController {

  @Override
  public void accept() {
    Student student = AppViewContext.delStudentDialog.getStudent();
    AppRepositoryContext.studentRepository.remove(student);
    AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
    AppViewContext.delStudentDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.delStudentDialog.close();
  }

}
