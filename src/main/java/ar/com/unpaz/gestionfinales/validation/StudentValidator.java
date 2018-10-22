package ar.com.unpaz.gestionfinales.validation;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import java.util.regex.Pattern;
import ar.com.unpaz.gestionfinales.domain.Student;

public class StudentValidator extends SkeletonValidator<Student> {

  @Override
  void validateFieldOf(Student entity) {
    checkDNI(entity);
    checkName(entity);
    checkSurname(entity);
    checkEmail(entity);
    checkEmailFormat(entity);
  }
  
  private static String ERROR_DNI_MSG = "DNI invalido";

  void checkDNI(Student entity) {
    if (!isDNI(entity.getDni())) {
      setErrorMessage(ERROR_DNI_MSG);
    }
  }

  private static boolean isDNI(String strDni) {
    return compile("[\\d$]{7,8}").matcher(strDni).matches();
  }

  private static String ERROR_NAME_MSG = "Ingrese nombre";

  void checkName(Student entity) {
    if (entity.hasEmptyName()) {
      setErrorMessage(ERROR_NAME_MSG);
    }
  }

  private static String ERROR_SURNAME_MSG = "Ingrese apellido";

  void checkSurname(Student entity) {
    if (entity.hasEmptySurname()) {
      setErrorMessage(ERROR_SURNAME_MSG);
    }
  }

  private static String ERROR_EMAIL_MSG = "Ingrese email";

  void checkEmail(Student entity) {
    if (entity.hasEmptyEmail()) {
      setErrorMessage(ERROR_EMAIL_MSG);
    }
  }

  private static String ERROR_EMAIL_FORMAT = "Parece que el email es incorrecto";

  void checkEmailFormat(Student entity) {
    if (!VALID_EMAIL_ADDRESS_REGEX.matcher(entity.getEmail()).find()) {
      setErrorMessage(ERROR_EMAIL_FORMAT);
    }
  }

  private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", CASE_INSENSITIVE);
 
}
