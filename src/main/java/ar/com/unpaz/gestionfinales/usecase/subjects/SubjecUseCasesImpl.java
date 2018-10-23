package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.UseCases;

public class SubjecUseCasesImpl implements UseCases<Subject> {

  public SubjecUseCasesImpl() {
    AppViewContext.addSubjectDialog.setController(new AddSubjectUseCase());
    AppViewContext.updSubjectDialog.setController(new UpdateSubjectUseCase());
    AppViewContext.delSubjectDialog.setController(new DeleteSubjectUseCase());
    AppViewContext.reportSubjectDialog.setController(new ReportSubjectUseCase());
  }

  @Override
  public void add() {
    AppViewContext.addSubjectDialog.set(Subject.EMPTY);
    AppViewContext.addSubjectDialog.showError("");
    AppViewContext.addSubjectDialog.show();
  }

  @Override
  public void delete() {
    if (AppViewContext.subjectsView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectsView.getSelectedRow();
      Subject selected = AppViewContext.subjectsView.getInRow(row);
      AppViewContext.delSubjectDialog.set(selected);
      AppViewContext.delSubjectDialog.show();
    }
  }

  @Override
  public void update() {
    if (AppViewContext.subjectsView.getSelectedRow() != -1) {
      int row = AppViewContext.subjectsView.getSelectedRow();
      Subject selected = AppViewContext.subjectsView.getInRow(row);
      AppViewContext.updSubjectDialog.set(selected);
      AppViewContext.updSubjectDialog.show();
    }
  }

  @Override
  public void report() {
    AppViewContext.reportSubjectDialog.show();
  }

}
