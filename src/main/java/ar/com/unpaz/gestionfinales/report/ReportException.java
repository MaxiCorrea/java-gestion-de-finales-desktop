package ar.com.unpaz.gestionfinales.report;

public class ReportException extends Exception {
  private static final long serialVersionUID = 1L;

  private static final String ERROR = "Error en la creacion de reporte";
  
  public ReportException() {
    super(ERROR);
  }
  
}
