package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class StudentSelectionController implements DialogController {

  @Override
  public void accept() {
    if (AppViewContext.selectStudentDialog.getSelectedRow() != -1) {
      int row = AppViewContext.selectStudentDialog.getSelectedRow();
      Student student = AppViewContext.selectStudentDialog.getStudentInRow(row);
      AppViewContext.addFinalDialog.setStudent(student);
      AppViewContext.selectStudentDialog.close();
    }
  }

  @Override
  public void cancel() {
    AppViewContext.selectStudentDialog.close();
  }
  
}
