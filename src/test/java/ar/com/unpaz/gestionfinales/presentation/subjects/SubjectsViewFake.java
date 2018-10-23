package ar.com.unpaz.gestionfinales.presentation.subjects;

import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.View;

public class SubjectsViewFake implements View<Subject> {

  private List<Subject> subjectsShown = new ArrayList<>();

  @Override
  public void show() {}

  @Override
  public void set(List<Subject> subjects) {
    this.subjectsShown = subjects;
  }

  @Override
  public int getSelectedRow() {
    return 0;
  }

  @Override
  public Subject getInRow(int rowIndex) {
    return subjectsShown.get(rowIndex);
  }

  public List<Subject> getSubjects() {
    return subjectsShown;
  }
  
}
