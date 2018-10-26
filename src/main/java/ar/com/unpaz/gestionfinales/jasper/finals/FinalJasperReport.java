package ar.com.unpaz.gestionfinales.jasper.finals;

import static net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile;
import static net.sf.jasperreports.engine.JasperFillManager.fillReportToFile;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.jasper.UtilPDF;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class FinalJasperReport implements Report<Final> {

  private static final String JASPER = "src/main/resources/reports/finals.jasper";
  private static final String JPRINT = "src/main/resources/reports/finals.jrprint";

  @Override
  public void generateReport(File file, List<Final> all) throws ReportException {
    try {
      FinalDataSource src = new FinalDataSource();
      fillReportToFile(JASPER, new HashMap<>(), src.createReportDataSource(all));
      exportReportToPdfFile(JPRINT, UtilPDF.addExtension(file.getAbsolutePath()));
    } catch (Exception jrex) {
      jrex.printStackTrace();
      throw new ReportException();
    }
  }
  
}
