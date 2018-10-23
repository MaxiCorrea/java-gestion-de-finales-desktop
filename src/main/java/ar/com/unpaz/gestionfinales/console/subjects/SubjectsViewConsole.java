package ar.com.unpaz.gestionfinales.console.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.View;

public class SubjectsViewConsole implements View<Subject> {

  private SubjectTableConsole table;

  public SubjectsViewConsole() {
    table = new SubjectTableConsole();
  }

  @Override
  public void show() {
    table.print();
  }

  @Override
  public void set(List<Subject> subjects) {
    table.updateList(subjects);
  }

  @Override
  public int getSelectedRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Subject getInRow(int rowIndex) {
    return table.getInRow(rowIndex);
  }

}
