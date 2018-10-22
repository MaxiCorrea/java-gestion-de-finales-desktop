package ar.com.unpaz.gestionfinales.presentation.subjects;

import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsView;
import ar.com.unpaz.gestionfinales.presentation.subjects.YearCombo;

public class SubjectsViewFake implements SubjectsView {

  private List<Subject> subjectsShown = new ArrayList<>();

  @Override
  public void show() {}

  @Override
  public void setSubjects(List<Subject> subjects) {
    this.subjectsShown = subjects;
  }

  @Override
  public int getSelectedRow() {
    return 0;
  }

  @Override
  public Subject getSubjectInRow(int rowIndex) {
    return subjectsShown.get(rowIndex);
  }

  @Override
  public YearCombo getYearSelected() {
    return null;
  }

}
