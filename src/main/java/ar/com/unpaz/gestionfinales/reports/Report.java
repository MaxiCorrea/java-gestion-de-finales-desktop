package ar.com.unpaz.gestionfinales.reports;

public interface Report {

  void generateReport(String absolutePath) throws ReportException;

}
