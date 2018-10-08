package ar.com.unpaz.gestionfinales.presentation.controller.local;

import static ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext.subjectRepository;
import static ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext.subjectAddDialog;
import static ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext.subjectView;
import ar.com.unpaz.gestionfinales.persistence.filters.FilterByFirstYearSpecification;
import ar.com.unpaz.gestionfinales.persistence.filters.FilterBySecondYearSpecification;
import ar.com.unpaz.gestionfinales.presentation.controller.SubjectController;
import ar.com.unpaz.gestionfinales.presentation.model.YearCombo;

public class LocalSubjecController implements SubjectController {

  @Override
  public void addSubject() {
    subjectAddDialog.clearDescription();
    subjectAddDialog.resetYear();
    subjectAddDialog.show();
  }

  @Override
  public void deleteSubject() {

  }

  @Override
  public void updateSubject() {

  }

  @Override
  public void filterByYear() {
    YearCombo combo = subjectView.getSelectedYear();
    if (combo == YearCombo.SELECT) {
      subjectView.update(subjectRepository.getAll());
    }
    if (combo == YearCombo.FIRST) {
      subjectView.update(subjectRepository.query(new FilterByFirstYearSpecification()));
    }
    if (combo == YearCombo.SECOND) {
      subjectView.update(subjectRepository.query(new FilterBySecondYearSpecification()));
    }
  }

}
