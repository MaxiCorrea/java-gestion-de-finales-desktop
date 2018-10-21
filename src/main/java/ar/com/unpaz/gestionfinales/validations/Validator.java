package ar.com.unpaz.gestionfinales.validations;

public interface Validator<E> {

  boolean isValid(E entity);
  
  String getErrorMessage();
  
}
