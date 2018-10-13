package ar.com.unpaz.gestionfinales.presentation.students;

import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;

public interface StudentsView {

  int getSelectedRow();

  Student getStudentInRow(int row);

  void setStudents(List<Student> all);

  void show();

}
