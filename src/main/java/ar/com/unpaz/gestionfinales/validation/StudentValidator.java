package ar.com.unpaz.gestionfinales.validation;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import java.util.regex.Pattern;
import ar.com.unpaz.gestionfinales.domain.Student;

public class StudentValidator implements Validator<Student> {
  
  private static String NO_ERROR = "";

  private String errorMessage;

  public StudentValidator() {
    errorMessage = NO_ERROR;
  }

  @Override
  public boolean isValid(Student entity) {
    checkDNI(entity);
    checkName(entity);
    checkSurname(entity);
    checkEmail(entity);
    checkEmailFormat(entity);
    return errorMessage.equals(NO_ERROR);
  }

  private static String ERROR_DNI_MSG = "DNI invalido";
  
  private void checkDNI(Student entity) {
    if (!isDNI(entity.getDni())) {
      errorMessage = ERROR_DNI_MSG;
    }
  }

  private static boolean isDNI(String strDni) {
    return compile("[\\d$]{7,8}").matcher(strDni).matches();
  }

  private static String ERROR_NAME_MSG = "Ingrese nombre";
  
  private void checkName(Student entity) {
    if (entity.hasEmptyName()) {
      errorMessage = ERROR_NAME_MSG;
    }
  }

  private static String ERROR_SURNAME_MSG = "Ingrese apellido";
  
  private void checkSurname(Student entity) {
    if (entity.hasEmptySurname()) {
      errorMessage = ERROR_SURNAME_MSG;
    }
  }

  public static String ERROR_EMAIL_MSG = "Ingrese email";
  
  private void checkEmail(Student entity) {
    if (entity.hasEmptyEmail()) {
      errorMessage = ERROR_EMAIL_MSG;
    }
  }

  private static String ERROR_EMAIL_FORMAT = "Parece que el email es incorrecto";
  
  private void checkEmailFormat(Student entity) {
    if (!VALID_EMAIL_ADDRESS_REGEX.matcher(entity.getEmail()).find()) {
      errorMessage = ERROR_EMAIL_FORMAT;
    }
  }

  static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", CASE_INSENSITIVE);
  
  @Override
  public String getErrorMessage() {
    String message = errorMessage;
    errorMessage = NO_ERROR;
    return message;
  }

}
