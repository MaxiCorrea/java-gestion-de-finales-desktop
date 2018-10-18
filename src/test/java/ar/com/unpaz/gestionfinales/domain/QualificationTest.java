package ar.com.unpaz.gestionfinales.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class QualificationTest {

  @Test
  public void theQualificationAreNumberedFromZeroToTen() {
    int numbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (Qualification q : Qualification.values()) {
      assertEquals(numbers[q.ordinal()], q.number);
    }
  }

  @Test
  public void shouldBeAbleToGetTheQualificationFromAnInt() {
    int numbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int value : numbers) {
      assertEquals(value, Qualification.of(value).number);
    }
  }

  @Test
  public void theMethodToStringReturnsTheRepresentationInAInt() {
    String numbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    for (Qualification q : Qualification.values()) {
      assertEquals(numbers[q.ordinal()], q.toString());
    }
  }

}
