package ar.com.unpaz.gestionfinales.validation;

import static ar.com.unpaz.gestionfinales.domain.Year.NONE;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class SubjectValidator implements Validator<Subject> {

  private static String YEAR_ERROR_MSG = "Seleccione el año";
  private static String DESC_ERROR_MSG_1 = "Ingrese descripcion";
  private static String DESC_ERROR_MSG_2 = "Descripcion muy larga";
  private static String NO_ERROR = "";

  private String errorMessage;

  public SubjectValidator() {
    errorMessage = NO_ERROR;
  }

  @Override
  public boolean isValid(Subject entity) {
    checkYear(entity);
    checkDescriptionEmpty(entity);
    checkDescriptionLenght(entity);
    return errorMessage.equals(NO_ERROR);
  }

  private void checkYear(Subject entity) {
    if (entity.haveThisYear(NONE)) {
      errorMessage = YEAR_ERROR_MSG;
    }
  }

  private void checkDescriptionEmpty(Subject entity) {
    if (entity.hasEmptyDescription()) {
      errorMessage = DESC_ERROR_MSG_1;
    }
  }

  private void checkDescriptionLenght(Subject entity) {
    if (entity.getDescription().length() > 
        Subject.MAX_NUMBER_OF_CHARACTERS) {
      errorMessage = DESC_ERROR_MSG_2;
    }
  }

  @Override
  public String getErrorMessage() {
    String message = errorMessage;
    errorMessage = NO_ERROR;
    return message;
  }

}
