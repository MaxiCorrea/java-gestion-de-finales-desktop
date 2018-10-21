package ar.com.unpaz.gestionfinales.report;

public interface Report {

  void generateReport(String absolutePath) throws ReportException;

}
