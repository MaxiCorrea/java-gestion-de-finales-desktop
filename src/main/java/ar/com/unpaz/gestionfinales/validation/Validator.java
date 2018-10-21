package ar.com.unpaz.gestionfinales.validation;

public interface Validator<E> {

  boolean isValid(E entity);
  
  String getErrorMessage();
  
}
