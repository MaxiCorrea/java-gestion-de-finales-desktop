package ar.com.unpaz.gestionfinales.console.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsView;
import ar.com.unpaz.gestionfinales.presentation.subjects.YearCombo;

public class SubjectsViewConsole implements SubjectsView {

  private SubjectTableConsole table;

  public SubjectsViewConsole() {
    table = new SubjectTableConsole();
  }

  @Override
  public void show() {
    table.print();
  }

  @Override
  public void setSubjects(List<Subject> subjects) {
    table.updateList(subjects);
  }

  @Override
  public int getSelectedRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Subject getSubjectInRow(int rowIndex) {
    return table.getInRow(rowIndex);
  }

  @Override
  public YearCombo getYearSelected() {
    // TODO Auto-generated method stub
    return null;
  }

}
