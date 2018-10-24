package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCases;

public class StudentUseCases extends SkeletonUseCases<Student> {

  {
    AppViewContext.addStudentDialog.setController(new AddStudentUseCase());
    AppViewContext.updStudentDialog.setController(new UpdateStudentUseCase());
    AppViewContext.delStudentDialog.setController(new DeleteStudentUseCase());
    AppViewContext.reportStudentDialog.setController(new ReportStudentUseCase());
  }

  public StudentUseCases() {
    super(AppViewContext.addStudentDialog,
          AppViewContext.delStudentDialog, 
          AppViewContext.updStudentDialog,
          AppViewContext.reportStudentDialog,
          AppViewContext.studentsView);
  }
  
  @Override
  public void add() {
    AppViewContext.addStudentDialog.set(Student.EMPTY);
    super.add();
  }

}
