package ar.com.unpaz.gestionfinales.presentation.view;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.model.YearCombo;

public interface SubjectsView {

  void show();

  void setSubjects(List<Subject> subjects);

  int getSelectedRow();

  Subject getSubjectInRow(int rowIndex);

  YearCombo getYearSelected();
  
}
