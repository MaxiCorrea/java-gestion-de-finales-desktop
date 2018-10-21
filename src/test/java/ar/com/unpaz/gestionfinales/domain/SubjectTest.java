package ar.com.unpaz.gestionfinales.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubjectTest {

  @Test
  public void aSubjectShouldStoreADescriptionAndYearAndId() {
    Subject subject = new Subject(10, "A Description", Year.NONE);
    int expectedId = 10;
    assertEquals(expectedId, subject.getId());
    String expectedDescription = "A Description";
    assertEquals(expectedDescription, subject.getDescription());
    Year expectedYear = Year.NONE;
    assertEquals(expectedYear, subject.getYear());
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotCreateASubjectWithANullDescription() {
    new Subject(null,Year.NONE);
  }
  
  @Test(expected = NullPointerException.class)
  public void shouldNotCreateASubjectWithANullYear() {
    new Subject("",null);
  }
  
  @Test
  public void aSubjectShouldStoreADescriptionAndYear() {
    Subject subject = new Subject("A Description", Year.FIRST);
    int expectedId = 0;
    assertEquals(expectedId, subject.getId());
    String expectedDescription = "A Description";
    assertEquals(expectedDescription, subject.getDescription());
    Year expectedYear = Year.FIRST;
    assertEquals(expectedYear, subject.getYear());
  }
  
  @Test
  public void aSubjectCanBeCreatedWithDefaultConstructor() {
    Subject subject = new Subject();
    int expectedId = 0;
    assertEquals(expectedId, subject.getId());
    String expectedDescription = "";
    assertEquals(expectedDescription, subject.getDescription());
    Year expectedYear = Year.NONE;
    assertEquals(expectedYear, subject.getYear());
  }

  @Test
  public void shouldIndicateIfItHasASpecificYear() {
    Subject subject = new Subject("",Year.SECOND);
    assertFalse(subject.haveThisYear(Year.FIRST));
    assertTrue(subject.haveThisYear(Year.SECOND));
  }
  
  @Test
  public void shouldIndicateIfItsDescriptionIsEmpty() {
    Subject subject = new Subject();
    assertTrue(subject.hasEmptyDescription());
    Subject subject2 = new Subject("-",Year.NONE);
    assertFalse(subject2.hasEmptyDescription());
  }
  
  @Test
  public void theMaximumNumberOfCharactersInADescriptionOf50() {
    int expectedMaximin = 50;
    assertEquals(expectedMaximin , Subject.MAX_NUMBER_OF_CHARACTERS);
  }
  
}
