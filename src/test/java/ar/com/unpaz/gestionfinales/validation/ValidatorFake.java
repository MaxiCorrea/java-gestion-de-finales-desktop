package ar.com.unpaz.gestionfinales.validation;

import ar.com.unpaz.gestionfinales.validation.Validator;

public class ValidatorFake<E> implements Validator<E> {

  private boolean valueReturnedByIsValid;
  private String valueReturnedByGetErrorMessage;
  
  @Override
  public boolean isValid(E entity) {
    return valueReturnedByIsValid;
  }

  public void isValidWillReturnTrue() {
    valueReturnedByIsValid = true;
  }
  
  public void isValidWillReturnFalse() {
    valueReturnedByIsValid = false;
  }
  
  public void getErrorMessageReturn(String message) {
    valueReturnedByGetErrorMessage = message;
  }
  
  @Override
  public String getErrorMessage() {
    return valueReturnedByGetErrorMessage;
  }

}
