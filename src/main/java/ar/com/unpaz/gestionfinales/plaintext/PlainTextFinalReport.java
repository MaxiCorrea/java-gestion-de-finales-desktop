package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextFinalReport implements Report<Final> {

  @Override
  public void generateReport(File file, List<Final> all) throws ReportException {
    try(FileWriter out = new FileWriter(file) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Final finalObj : all) {
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
