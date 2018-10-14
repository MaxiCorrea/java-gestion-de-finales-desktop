package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class StudentUseCasesImpl implements StudentUseCases {

  public StudentUseCasesImpl() {
    AppViewContext.addStudentDialog.setController(new AddStudentUseCase());
    AppViewContext.updStudentDialog.setController(new UpdateStudentUseCase());
    AppViewContext.delStudentDialog.setController(new DeleteStudentUseCase());
    AppViewContext.reportStudentDialog.setController(new ReportStudentUseCase());
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

  @Override
  public void generateReport() {
    AppViewContext.reportStudentDialog.show();
  }

}
