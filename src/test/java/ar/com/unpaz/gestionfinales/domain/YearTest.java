package ar.com.unpaz.gestionfinales.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class YearTest {

  @Test
  public void theYearAreNumberedFromZeroToFifth() {
    int numbers[] = {0, 1, 2, 3, 4, 5};
    for (Year y : Year.values()) {
      assertEquals(numbers[y.ordinal()], y.number);
    }
  }

  @Test
  public void shouldBeAbleToGetTheYearFromAnInt() {
    int numbers[] = {0, 1, 2, 3, 4, 5};
    for (int value : numbers) {
      assertEquals(value, Year.of(value).number);
    }
  }

  @Test
  public void theMethodToStringReturnsTheRepresentationInAInt() {
    String numbers[] = {"0", "1", "2", "3", "4", "5"};
    for (Year y : Year.values()) {
      assertEquals(numbers[y.ordinal()], y.toString());
    }
  }
}
