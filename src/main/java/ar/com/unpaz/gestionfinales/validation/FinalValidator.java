package ar.com.unpaz.gestionfinales.validation;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class FinalValidator extends SkeletonValidator<Final> {

  @Override
  void validateFieldsOf(Final entity) {
    checkQualification(entity);
    checkSubject(entity);
    checkStudent(entity);
  }
  
  private static String QUALIFICATION_ERROR = "Seleccione Nota";
  
  void checkQualification(Final finalObj) {
    if(finalObj.hasThisQualification(Qualification.NONE)) {
      setErrorMessage(QUALIFICATION_ERROR);
    }
  }

  private static String SUBJECT_ERROR = "Seleccione Materia";
  
  void checkSubject(Final finalObj) {
    if(finalObj.hasThisSubject(Subject.EMPTY)) {
      setErrorMessage(SUBJECT_ERROR);
    }
  }

  private static String STUDENT_ERROR = "Seleccione Alumno";
  
  void checkStudent(Final finalObj) {
    if(finalObj.hasThisStudent(Student.EMPTY)) {
      setErrorMessage(STUDENT_ERROR);
    }
  }

}
