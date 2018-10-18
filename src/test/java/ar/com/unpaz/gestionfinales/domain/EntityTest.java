package ar.com.unpaz.gestionfinales.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class EntityTest {

  @Test
  public void byDefaultTheIDIsZero() {
    Entity entity = new Entity();
    assertEquals(0, entity.getId());
  }

  @Test
  public void shouldBeAbleToSetTheIdInConstructor() {
    Entity entity = new Entity(10);
    int expectedId = 10;
    assertEquals(expectedId, entity.getId());
  }

}
