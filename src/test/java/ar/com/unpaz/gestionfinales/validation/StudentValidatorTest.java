package ar.com.unpaz.gestionfinales.validation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.domain.Student;

public class StudentValidatorTest {

  private StudentValidator validator;

  @Before
  public void setup() {
    validator = new StudentValidator();
  }

  @Test
  public void theIDMustBeAIntegerNumber() {
    validator.checkDNI(new Student("asdasd", "", "", ""));
    assertTrue(validator.hasErrors());
  }

  @Test
  public void theIDShouldNotBeEmpty() {
    validator.checkDNI(new Student("", "", "", ""));
    assertTrue(validator.hasErrors());
  }

  @Test
  public void theIDShouldNotHaveLessThanSevenDigits() {
    validator.checkDNI(new Student("1234", "", "", ""));
    assertTrue(validator.hasErrors());
  }

  @Test
  public void aDNIWithASevenDigitIntegerValueIsValid() {
    validator.checkDNI(new Student("1234567", "", "", ""));
    assertFalse(validator.hasErrors());
  }

  @Test
  public void aDNIWithAnIntegerValueOfEightDigitsIsValid() {
    validator.checkDNI(new Student("12345678", "", "", ""));
    assertFalse(validator.hasErrors());
  }

  @Test
  public void aDNIWithMoreThanNineDigitsIsInvalid() {
    validator.checkDNI(new Student("123456789", "", "", ""));
    assertTrue(validator.hasErrors());
  }

  @Test
  public void theNameCanNotBeBlank() {
    validator.checkName(new Student("","","",""));
    assertTrue(validator.hasErrors());
  }
  
  @Test
  public void theSurnameCanNotBeBlank() {
    validator.checkSurname(new Student("","","",""));
    assertTrue(validator.hasErrors());
  }
  
  @Test
  public void theEmailCanNotBeEmpty() {
    validator.checkEmail(new Student("","","",""));
    assertTrue(validator.hasErrors());
  }
  
  @Test
  public void testingValidEmail() {
    validator.checkEmail(new Student("","","","jmaxicorrea@gmail.com"));
    assertFalse(validator.hasErrors());
  }
  
}
