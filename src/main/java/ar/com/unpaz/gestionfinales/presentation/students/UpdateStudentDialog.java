package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface UpdateStudentDialog {

  void setController(DialogController controller);

  void setStudent(Student selected);

  Student getStudent();
  
  void show();
  
  void close();

}
