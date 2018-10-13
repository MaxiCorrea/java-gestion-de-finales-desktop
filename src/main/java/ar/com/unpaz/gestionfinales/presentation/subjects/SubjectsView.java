package ar.com.unpaz.gestionfinales.presentation.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;

public interface SubjectsView {

  void show();

  void setSubjects(List<Subject> subjects);

  int getSelectedRow();

  Subject getSubjectInRow(int rowIndex);

  YearCombo getYearSelected();
  
}
