package ar.com.unpaz.gestionfinales.validation;

import static ar.com.unpaz.gestionfinales.domain.Year.NONE;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class SubjectValidator extends SkeletonValidator<Subject> {
 
  @Override
  void validateFieldsOf(Subject entity) {
    checkYear(entity);
    checkDescriptionEmpty(entity);
    checkDescriptionLenght(entity);
  }
  
  private static String YEAR_ERROR_MSG = "Seleccione el año";
  
  void checkYear(Subject entity) {
    if (entity.haveThisYear(NONE)) {
      setErrorMessage(YEAR_ERROR_MSG);
    }
  }

  private static String DESC_ERROR_MSG_1 = "Ingrese descripcion";
  
  void checkDescriptionEmpty(Subject entity) {
    if (entity.hasEmptyDescription()) {
      setErrorMessage(DESC_ERROR_MSG_1);
    }
  }

  private static String DESC_ERROR_MSG_2 = "Descripcion muy larga";
  
  void checkDescriptionLenght(Subject entity) {
    if (entity.getDescription().length() > 
        Subject.MAX_NUMBER_OF_CHARACTERS) {
      setErrorMessage(DESC_ERROR_MSG_2);
    }
  }

}
