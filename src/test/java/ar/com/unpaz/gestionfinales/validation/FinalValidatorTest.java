package ar.com.unpaz.gestionfinales.validation;

import static ar.com.unpaz.gestionfinales.domain.Qualification.FIVE;
import static ar.com.unpaz.gestionfinales.domain.Qualification.NONE;
import static ar.com.unpaz.gestionfinales.domain.Qualification.TEN;
import static ar.com.unpaz.gestionfinales.domain.Year.FIRST;
import static java.time.LocalDate.now;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class FinalValidatorTest {

  private static Subject subjectValid = new Subject("A Description", FIRST);
  private static Student studentValid = new Student(0, "Maxi", "Correa", "jmaxicorrea@gmail.com");

  private FinalValidator validator;

  @Before
  public void setup() {
    validator = new FinalValidator();
  }

  @Test
  public void aFinalMustHaveASubject() {
    Final finalObj = new Final(0, Subject.EMPTY, studentValid, now(), FIVE);
    validator.checkSubject(finalObj);
    assertTrue(validator.hasErrors());
  }

  @Test
  public void aFinalMustHaveAStudent() {
    Final finalObj = new Final(0, subjectValid, Student.EMPTY, now(), FIVE);
    validator.checkStudent(finalObj);
    assertTrue(validator.hasErrors());
  }

  @Test
  public void aFinalMustHaveAQualification() {
    Final finalObj = new Final(0, subjectValid, Student.EMPTY, now(), NONE);
    validator.checkQualification(finalObj);
    assertTrue(validator.hasErrors());
  }

  @Test
  public void testingFinalValid() {
    Final finalObj = new Final(0, subjectValid, studentValid, now(), TEN);
    assertTrue(validator.isValid(finalObj));
    assertFalse(validator.hasErrors());
  }

}
