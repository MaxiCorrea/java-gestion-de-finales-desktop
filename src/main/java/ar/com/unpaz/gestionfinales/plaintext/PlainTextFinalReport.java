package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextFinalReport implements Report {

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try(FileWriter out = new FileWriter(absolutePath) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Final finalObj : AppRepositoryContext.finalRepository.getAll()) {
        buffer.write(formatString(finalObj));
        buffer.newLine();
      }
    } catch(IOException ex) {
      throw new ReportException();
    }
  }

  private static final String SLASH = "/";
  
  String formatString(Final finalObj) {
    return new StringBuilder().append(finalObj.getId())
                              .append(SLASH)
                              .append(finalObj.getSubject().getDescription())
                              .append(SLASH)
                              .append(finalObj.getDate())
                              .append(SLASH)
                              .append(finalObj.getQualification().number)
                              .toString();
  }
  
}
