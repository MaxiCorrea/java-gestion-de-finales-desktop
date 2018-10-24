package ar.com.unpaz.gestionfinales.presentation.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface SelectStudentDialog {
  
  void setController(DialogController controller);

  int getSelectedRow();

  Student getInRow(int row);

  void set(List<Student> students);

  void show();

  void close();

}
