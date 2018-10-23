package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class SubjectSelectionController implements DialogController {

  @Override
  public void accept() {
    if (AppViewContext.selectSubjectDialog.getSelectedRow() != -1) {
      int row = AppViewContext.selectSubjectDialog.getSelectedRow();
      Subject subject = AppViewContext.selectSubjectDialog.getSubjectInRow(row);
      AppViewContext.addFinalDialog.setSubject(subject);
      AppViewContext.selectSubjectDialog.close();
    }
  }

  @Override
  public void cancel() {
    AppViewContext.selectSubjectDialog.close();
  }
  
}
