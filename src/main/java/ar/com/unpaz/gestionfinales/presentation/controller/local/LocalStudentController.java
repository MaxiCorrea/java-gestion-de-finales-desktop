package ar.com.unpaz.gestionfinales.presentation.controller.local;

import ar.com.unpaz.gestionfinales.presentation.controller.StudentController;

public class LocalStudentController implements StudentController {

  @Override
  public void addStudent() {
    System.out.println("addStudent");
  }

  @Override
  public void deleteStudent() {
    System.out.println("deleteStudent");
  }

  @Override
  public void updateStudent() {
    System.out.println("updateStudent");
  }

}
