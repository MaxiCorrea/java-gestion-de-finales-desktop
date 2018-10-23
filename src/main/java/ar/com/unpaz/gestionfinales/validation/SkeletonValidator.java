package ar.com.unpaz.gestionfinales.validation;

public abstract class SkeletonValidator<E> implements Validator<E> {

  private static String NO_ERROR = "";

  private String errorMessage;
  
  public SkeletonValidator() {
    errorMessage = NO_ERROR;
  }
  
  @Override
  public final boolean isValid(E entity) {
    validateFieldsOf(entity);
    return !hasErrors();
  }

  final boolean hasErrors() {
    return !errorMessage.equals(NO_ERROR);
  }

  abstract void validateFieldsOf(E entity);
  
  void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String getErrorMessage() {
    String message = errorMessage;
    errorMessage = NO_ERROR;
    return message;
  }

}
