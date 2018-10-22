package ar.com.unpaz.gestionfinales.validation;

import ar.com.unpaz.gestionfinales.domain.Subject;

public class NoSubjectValidator implements Validator<Subject>{

  @Override
  public boolean isValid(Subject entity) {
    return true;
  }

  @Override
  public String getErrorMessage() {
    return "";
  }

}
