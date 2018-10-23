package ar.com.unpaz.gestionfinales.validation;

public class NullValidator<E> implements Validator<E> {

  @Override
  public boolean isValid(E entity) {
    return true;
  }

  @Override
  public String getErrorMessage() {
    return "";
  }

}
