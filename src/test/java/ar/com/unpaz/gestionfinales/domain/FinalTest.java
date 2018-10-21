package ar.com.unpaz.gestionfinales.domain;

import static ar.com.unpaz.gestionfinales.domain.Qualification.NONE;
import static java.time.LocalDate.now;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class FinalTest {

  @Test
  public void aFinalMustContainASubjectAStudentADateAndAQualification() {
    Final finalObj = new Final();
    assertNotNull(finalObj.getSubject());
    assertNotNull(finalObj.getStudent());
    assertNotNull(finalObj.getDate());
    assertNotNull(finalObj.getQualification());
  }

  @Test(expected = NullPointerException.class)
  public void anFinalMustHaveASubjectNotNull() {
    new Final(0, null, Student.EMPTY, now(), NONE);
  }

  @Test(expected = NullPointerException.class)
  public void anFinalMustHaveAStudentNotNull() {
    new Final(0, Subject.EMPTY, null, now(), NONE);
  }

  @Test(expected = NullPointerException.class)
  public void anFinalMustHaveADateNotNull() {
    new Final(0, Subject.EMPTY, Student.EMPTY, null, NONE);
  }
  
  @Test(expected = NullPointerException.class)
  public void anFinalMustHaveAQualificationNotNull() {
    new Final(0, Subject.EMPTY, Student.EMPTY, now(), null);
  }
  
}
