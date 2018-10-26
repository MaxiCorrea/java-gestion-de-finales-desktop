package ar.com.unpaz.gestionfinales.validation;

import static org.junit.Assert.*;
import org.junit.Test;

public class NullValidatorTest {

  @Test
  public void theIsValidMethodAlwaysReturnsTrue() {
    NullValidator<String> nullValidator;
    nullValidator = new NullValidator<>();
    assertTrue(nullValidator.isValid(null));
    assertTrue(nullValidator.isValid("AAA"));
  }

  @Test
  public void theGetErrorMessageMethodAlwaysReturnsTrue() {
    NullValidator<String> nullValidator;
    nullValidator = new NullValidator<>();
    assertTrue(nullValidator.getErrorMessage().isEmpty());
    assertTrue(nullValidator.getErrorMessage().isEmpty());
    assertTrue(nullValidator.getErrorMessage().isEmpty());
  }

}
