package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.application.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.application.AppViewContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.inmemory.ByYearSpecification;

public class SubjecControllerImpl implements SubjectController {

  public SubjecControllerImpl() {
    AppViewContext.addSubjectDialog.setController(new AddSubjectUseCase());
    AppViewContext.updSubjectDialog.setController(new UpdateSubjectUseCase());
    AppViewContext.delSubjectDialog.setController(new DeleteSubjectUseCase());
    AppViewContext.reportSubjectDialog.setController(new ReportSubjectUseCase());
  }

  @Override
  public void addSubject() {
    AppViewContext.addSubjectDialog.setSubject(Subject.EMPTY);
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
    int year = AppViewContext.subjectsView.getYearSelected().ordinal();
    AppViewContext.subjectsView
        .setSubjects((year == 0) ? AppRepositoryContext.subjectRepository.getAll()
            : AppRepositoryContext.subjectRepository.query(new ByYearSpecification(year)));
  }

  @Override
  public void generateReport() {
    AppViewContext.reportSubjectDialog.show();
  }

}
