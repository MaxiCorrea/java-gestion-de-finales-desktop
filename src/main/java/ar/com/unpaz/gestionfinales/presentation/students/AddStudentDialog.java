package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public interface AddStudentDialog {

  void setController(DialogController controller);

  void show();

  void setStudent(Student student);

  Student getStudent();

  void close();

}
