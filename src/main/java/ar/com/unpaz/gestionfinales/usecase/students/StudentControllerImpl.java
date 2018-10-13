package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.application.AppViewContext;
import ar.com.unpaz.gestionfinales.domain.Student;

public class StudentControllerImpl implements StudentController {
 
  public StudentControllerImpl() {
    AppViewContext.addStudentDialog.setController(new AddStudentUseCase());
    AppViewContext.updStudentDialog.setController(new UpdateStudentUseCase());
    AppViewContext.delStudentDialog.setController(new DeleteStudentUseCase());
  }

  @Override
  public void addStudent() {
    AppViewContext.addStudentDialog.setStudent(Student.EMPTY);
    AppViewContext.addStudentDialog.show();
  }

  @Override
  public void deleteStudent() {
    if (AppViewContext.studentsView.getSelectedRow() != -1) {
      int row = AppViewContext.studentsView.getSelectedRow();
      Student selected = AppViewContext.studentsView.getStudentInRow(row);
      AppViewContext.delStudentDialog.setStudent(selected);
      AppViewContext.delStudentDialog.show();
    }
  }

  @Override
  public void updateStudent() {
    if (AppViewContext.studentsView.getSelectedRow() != -1) {
      int row = AppViewContext.studentsView.getSelectedRow();
      Student selected = AppViewContext.studentsView.getStudentInRow(row);
      AppViewContext.updStudentDialog.setStudent(selected);
      AppViewContext.updStudentDialog.show();
    }
  }
  
}
