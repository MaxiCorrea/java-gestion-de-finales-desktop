package ar.com.unpaz.gestionfinales.jasper.subjects;

import static net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile;
import static net.sf.jasperreports.engine.JasperFillManager.fillReportToFile;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class SubjectJasperReport implements Report<Subject> {

  private static final String JASPER = "src/main/resources/reports/subjects.jasper";
  private static final String JPRINT = "src/main/resources/reports/subjects.jrprint";

  @Override
  public void generateReport(File file, List<Subject> all) throws ReportException {
    try {
      SubjectDataSource src = new SubjectDataSource();
      fillReportToFile(JASPER, new HashMap<>(), src.createReportDataSource(all));
      exportReportToPdfFile(JPRINT, addExtension(file.getAbsolutePath()));
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
