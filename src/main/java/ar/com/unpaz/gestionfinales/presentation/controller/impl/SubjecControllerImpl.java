package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.controller.SubjectController;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;

public class SubjecControllerImpl implements SubjectController {

  public SubjecControllerImpl() {
    AppViewContext.addSubjectDialog.setController(new AddSubjectDialogController());
    AppViewContext.updSubjectDialog.setController(new UpdSubjectDialogController());
    AppViewContext.delSubjectDialog.setController(new DelSubjectDialogController());
  }

  public SubjecControllerImpl(DialogController addNewSubjectDialogController,
                              DialogController updSubjectDialogController, 
                              DialogController delSubjectDialogController) {

    AppViewContext.addSubjectDialog.setController(addNewSubjectDialogController);
    AppViewContext.updSubjectDialog.setController(updSubjectDialogController);
    AppViewContext.delSubjectDialog.setController(delSubjectDialogController);
  }


  @Override
  public void addSubject() {
    AppViewContext.addSubjectDialog.clearDescription();
    AppViewContext.addSubjectDialog.clearYear();
    AppViewContext.addSubjectDialog.show();
  }

  @Override
  public void deleteSubject() {
    if (AppViewContext.subjectView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectView.getSelectedRow();
      Subject selected = AppViewContext.subjectView.getSubjectInRow(row);
      AppViewContext.delSubjectDialog.setSubject(selected);
      AppViewContext.delSubjectDialog.show();
    }
  }

  @Override
  public void updateSubject() {
    if (AppViewContext.subjectView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectView.getSelectedRow();
      Subject selected = AppViewContext.subjectView.getSubjectInRow(row);
      AppViewContext.updSubjectDialog.setSubject(selected);
      AppViewContext.updSubjectDialog.show();
    }
  }

  @Override
  public void filterByYear() {
    int year = AppViewContext.subjectView.getYearSelected().ordinal();
    AppViewContext.subjectView
        .setSubjects((year == 0) ? AppRepositoryContext.subjectRepository.getAll()
            : AppRepositoryContext.subjectRepository.filterByYear(year));
  }

}
