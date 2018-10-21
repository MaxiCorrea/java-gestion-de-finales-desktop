package ar.com.unpaz.gestionfinales.validation;

import static ar.com.unpaz.gestionfinales.domain.Subject.MAX_NUMBER_OF_CHARACTERS;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;

public class SubjectValidatorTest {

  private SubjectValidator validator;

  @Before
  public void setup() {
    validator = new SubjectValidator();
  }

  @Test
  public void yearOfTheSubjectShouldNotBeNone() {
    Subject subject = Subject.EMPTY;
    validator.checkYear(subject);
    assertTrue(validator.hasErrors());
  }

  @Test
  public void theDescriptionShouldNotBeEmpty() {
    Subject subject = Subject.EMPTY;
    validator.checkDescriptionEmpty(subject);
    assertTrue(validator.hasErrors());
  }

  @Test
  public void theDescriptionMustNotExceed50Characters() {
    Subject subject = new Subject(getLargeDescription(), Year.FIFTH);
    validator.checkDescriptionLenght(subject);
    assertTrue(validator.hasErrors());
  }

  private String getLargeDescription() {
    StringBuilder builder = new StringBuilder();
    char c = 'a';
    for (int x = 0; x < MAX_NUMBER_OF_CHARACTERS + 1; ++x) {
      builder.append(c);
    }
    return builder.toString();
  }
}
