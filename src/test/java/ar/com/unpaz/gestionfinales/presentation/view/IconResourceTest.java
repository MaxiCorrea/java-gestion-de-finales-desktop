package ar.com.unpaz.gestionfinales.presentation.view;

import static org.junit.Assert.*;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource;
import ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource.IconPathOf;

public class IconResourceTest {

  @Test
  public void shouldLoadAllTheImages() {  
    for(IconPathOf path : IconPathOf.values()) {
      assertNotNull(IconResource.load(path));
    }
  }

}
