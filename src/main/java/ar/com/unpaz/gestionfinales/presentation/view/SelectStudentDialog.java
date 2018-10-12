package ar.com.unpaz.gestionfinales.presentation.view;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;

public interface SelectStudentDialog {
  
  void setController(DialogController controller);

  int getSelectedRow();

  Student getStudentInRow(int row);

  void setStudents(List<Student> students);

  void show();

  void close();

}
