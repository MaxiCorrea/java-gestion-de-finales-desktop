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

}
