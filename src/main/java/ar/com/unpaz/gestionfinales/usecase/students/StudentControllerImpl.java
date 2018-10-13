package ar.com.unpaz.gestionfinales.usecase.students;

import ar.com.unpaz.gestionfinales.application.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.application.AppViewContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class StudentControllerImpl implements StudentController {
 
  public StudentControllerImpl() {
    AppViewContext.addStudentDialog.setController(new AddStudentDialogController());
    AppViewContext.updStudentDialog.setController(new UpdStudentDialogController());
    AppViewContext.delStudentDialog.setController(new DelStudentDialogController());
  }

  public StudentControllerImpl(DialogController addStudentDialogController,
                               DialogController updStudentDialogController, 
                               DialogController delStudentDialogController) {

    AppViewContext.addStudentDialog.setController(addStudentDialogController);
    AppViewContext.updStudentDialog.setController(updStudentDialogController);
    AppViewContext.delStudentDialog.setController(delStudentDialogController);
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

  private class AddStudentDialogController implements DialogController {

    @Override
    public void accept() {
      Student student = AppViewContext.addStudentDialog.getStudent();
      AppRepositoryContext.studentRepository.add(student);
      AppViewContext.studentsView.setStudents(AppRepositoryContext.studentRepository.getAll());
      AppViewContext.addStudentDialog.close();
    }

    @Override
    public void cancel() {
      AppViewContext.addStudentDialog.close();
    }

  }
  
  private class DelStudentDialogController implements DialogController {

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

  private class UpdStudentDialogController implements DialogController {

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
  
}
