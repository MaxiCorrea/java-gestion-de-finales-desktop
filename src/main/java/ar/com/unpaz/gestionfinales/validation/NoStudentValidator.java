package ar.com.unpaz.gestionfinales.validation;

import ar.com.unpaz.gestionfinales.domain.Student;

public class NoStudentValidator implements Validator<Student> {

  @Override
  public boolean isValid(Student entity) {
    return true;
  }

  @Override
  public String getErrorMessage() {
    return "";
  }

}
