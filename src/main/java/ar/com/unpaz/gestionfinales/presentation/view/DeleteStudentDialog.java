package ar.com.unpaz.gestionfinales.presentation.view;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;

public interface DeleteStudentDialog {

  void setController(DialogController controller);

  void setStudent(Student selected);

  void show();

  void close();

  Student getStudent();
  
}
