package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class SubjecUseCasesImpl implements SubjectUseCases {

  public SubjecUseCasesImpl() {
    AppViewContext.addSubjectDialog.setController(new AddSubjectUseCase());
    AppViewContext.updSubjectDialog.setController(new UpdateSubjectUseCase());
    AppViewContext.delSubjectDialog.setController(new DeleteSubjectUseCase());
    AppViewContext.reportSubjectDialog.setController(new ReportSubjectUseCase());
  }

  @Override
  public void addSubject() {
    AppViewContext.addSubjectDialog.setSubject(Subject.EMPTY);
    AppViewContext.addSubjectDialog.showError("");
    AppViewContext.addSubjectDialog.show();
  }

  @Override
  public void deleteSubject() {
    if (AppViewContext.subjectsView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectsView.getSelectedRow();
      Subject selected = AppViewContext.subjectsView.getSubjectInRow(row);
      AppViewContext.delSubjectDialog.setSubject(selected);
      AppViewContext.delSubjectDialog.show();
    }
  }

  @Override
  public void updateSubject() {
    if (AppViewContext.subjectsView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectsView.getSelectedRow();
      Subject selected = AppViewContext.subjectsView.getSubjectInRow(row);
      AppViewContext.updSubjectDialog.setSubject(selected);
      AppViewContext.updSubjectDialog.show();
    }
  }

  @Override
  public void filterByYear() {
    
  }

  @Override
  public void generateReport() {
    AppViewContext.reportSubjectDialog.show();
  }

}
