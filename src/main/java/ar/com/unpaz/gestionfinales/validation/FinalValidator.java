package ar.com.unpaz.gestionfinales.validation;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class FinalValidator implements Validator<Final> {

  private static String NO_ERROR = "";

  private String errorMessage;

  public FinalValidator() {
    errorMessage = NO_ERROR;
  }

  @Override
  public boolean isValid(Final entity) {
    checkQualification(entity);
    checkSubject(entity);
    checkStudent(entity);
    return !hasErrors();
  }

  boolean hasErrors() {
    return !errorMessage.equals(NO_ERROR);
  }

  private static String QUALIFICATION_ERROR = "Seleccione Nota";
  
  void checkQualification(Final finalObj) {
    if(finalObj.hasThisQualification(Qualification.NONE)) {
      errorMessage = QUALIFICATION_ERROR;
    }
  }

  private static String SUBJECT_ERROR = "Seleccione Materia";
  
  void checkSubject(Final finalObj) {
    if(finalObj.hasThisSubject(Subject.EMPTY)) {
      errorMessage = SUBJECT_ERROR;
    }
  }

  private static String STUDENT_ERROR = "Seleccione Alumno";
  
  void checkStudent(Final finalObj) {
    if(finalObj.hasThisStudent(Student.EMPTY)) {
      errorMessage = STUDENT_ERROR;
    }
  }

  @Override
  public String getErrorMessage() {
    String message = errorMessage;
    errorMessage = NO_ERROR;
    return message;
  }

}
