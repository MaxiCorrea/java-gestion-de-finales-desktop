package ar.com.unpaz.gestionfinales.presentation.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface SelectSubjectDialog {

  void setController(DialogController controller);

  void show();

  void set(List<Subject> all);

  void close();

  int getSelectedRow();

  Subject getInRow(int row);

}
