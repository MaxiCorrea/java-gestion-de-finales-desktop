package ar.com.unpaz.gestionfinales.presentation.view;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;

public interface StudentView {

  int getSelectedRow();

  Student getStudentInRow(int row);

  void setStudents(List<Student> all);

  void show();

}
