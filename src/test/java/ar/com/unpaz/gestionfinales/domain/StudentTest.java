package ar.com.unpaz.gestionfinales.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {

  @Test
  public void aStudentShouldContainDNIAndFirstAndLastNameAndEmail() {
    Student student = new Student("0", "Maxi", "Correa", "jmaxicorrea@gmail.com");
    String expectedDNI = "0";
    assertEquals(expectedDNI, student.getDni());
    String expectedName = "Maxi";
    assertEquals(expectedName, student.getName());
    String expectedSurname = "Correa";
    assertEquals(expectedSurname, student.getSurname());
    String expectedEmail = "jmaxicorrea@gmail.com";
    assertEquals(expectedEmail, student.getEmail());
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotCreateAStudentWithADNI() {
    new Student(null , "" , "" , "");
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotCreateAStudentWithANullName() {
    new Student("",null , "" , "");
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotCreateAStudentWithANullSurname() {
    new Student("","", null , "");
  }

  @Test(expected = NullPointerException.class)
  public void shouldNotCreateAStudentWithNullEmail() {
    new Student("","","", null);
  }

  @Test
  public void studentShouldIndicateIfTheirDataIsEmpty() {
    Student student = new Student(0, "", "", "");
    assertTrue(student.hasEmptyEmail());
    assertTrue(student.hasEmptyName());
    assertTrue(student.hasEmptySurname());
    student = new Student(0 , "-",".",".");
    assertFalse(student.hasEmptyEmail());
    assertFalse(student.hasEmptyName());
    assertFalse(student.hasEmptySurname());
  }
  
  @Test
  public void shouldReturnHisFullName() {
    Student student = new Student(0, "Maximiliano", "Correa", "");
    String expectedFullName = "Maximiliano Correa";
    assertEquals(expectedFullName , student.getFullName());
  }
  
}
