package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddStudentUseCase implements DialogController {

  @Override
  public void accept() {
    Student student = AppViewContext.addStudentDialog.getStudent();
    String errorMessage = Student.validateFieldsOf(student);
    if(!errorMessage.isEmpty()) {
      AppViewContext.addStudentDialog.showError(errorMessage);
    } else {
      AppRepositoryContext.studentRepository.add(student);
      AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
      AppViewContext.addStudentDialog.close();
    }
  }
  
  @Override
  public void cancel() {
    AppViewContext.addStudentDialog.close();
  }

}
