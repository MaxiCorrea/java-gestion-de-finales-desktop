package ar.com.unpaz.gestionfinales.jasper;

import static net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile;
import static net.sf.jasperreports.engine.JasperFillManager.fillReportToFile;
import java.util.HashMap;
import ar.com.unpaz.gestionfinales.reports.Report;
import ar.com.unpaz.gestionfinales.reports.ReportException;

public class FinalJasperReport implements Report {

  private static final String JASPER = "src/main/resources/reports/finals.jasper";
  private static final String JPRINT = "src/main/resources/reports/finals.jrprint";

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try {
      fillReportToFile(JASPER, new HashMap<>(), new FinalDataSource().createReportDataSource());
      exportReportToPdfFile(JPRINT, addExtension(absolutePath));
    } catch (Exception jrex) {
      jrex.printStackTrace();
      throw new ReportException();
    }
  }

  String addExtension(String location) {
    if (location.lastIndexOf(".pdf") == -1) {
      return location + ".pdf";
    }
    return location;
  }

  
}
