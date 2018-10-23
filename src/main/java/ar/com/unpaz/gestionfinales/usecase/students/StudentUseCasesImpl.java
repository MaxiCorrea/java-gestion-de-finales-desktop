package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.UseCases;

public class StudentUseCasesImpl implements UseCases<Student> {

  public StudentUseCasesImpl() {
    AppViewContext.addStudentDialog.setController(new AddStudentUseCase());
    AppViewContext.updStudentDialog.setController(new UpdateStudentUseCase());
    AppViewContext.delStudentDialog.setController(new DeleteStudentUseCase());
    AppViewContext.reportStudentDialog.setController(new ReportStudentUseCase());
  }

  @Override
  public void add() {
    AppViewContext.addStudentDialog.set(Student.EMPTY);
    AppViewContext.addStudentDialog.showError("");
    AppViewContext.addStudentDialog.show();
  }

  @Override
  public void delete() {
    if (AppViewContext.studentsView.getSelectedRow() != -1) {
      int row = AppViewContext.studentsView.getSelectedRow();
      Student selected = AppViewContext.studentsView.getInRow(row);
      AppViewContext.delStudentDialog.set(selected);
      AppViewContext.delStudentDialog.show();
    }
  }

  @Override
  public void update() {
    if (AppViewContext.studentsView.getSelectedRow() != -1) {
      int row = AppViewContext.studentsView.getSelectedRow();
      Student selected = AppViewContext.studentsView.getInRow(row);
      AppViewContext.updStudentDialog.set(selected);
      AppViewContext.updStudentDialog.show();
    }
  }

  @Override
  public void report() {
    AppViewContext.reportStudentDialog.show();
  }

}
