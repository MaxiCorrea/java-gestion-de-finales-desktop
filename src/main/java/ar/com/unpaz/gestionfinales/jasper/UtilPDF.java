package ar.com.unpaz.gestionfinales.jasper;

public class UtilPDF {

  private UtilPDF() {
    throw new AssertionError();
  }

  public static String addExtension(String location) {
    if (location.lastIndexOf(".pdf") == -1) {
      return location + ".pdf";
    }
    return location;
  }

}
