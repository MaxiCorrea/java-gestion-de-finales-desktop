package ar.com.unpaz.gestionfinales.jasper;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UtilPDFTest {

  @Test
  public void test() {
    assertEquals("asdasd.pdf" , UtilPDF.addExtension("asdasd"));
  }

}
