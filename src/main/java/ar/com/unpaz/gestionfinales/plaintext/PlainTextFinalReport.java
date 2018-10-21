package ar.com.unpaz.gestionfinales.plaintext;

import static java.lang.String.valueOf;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextFinalReport implements Report {

  private static final String SLASH = "/";
  
  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try(FileWriter out = new FileWriter(absolutePath) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Final finalObj : AppRepositoryContext.finalRepository.getAll()) {
        buffer.write(valueOf(finalObj.getId()));
        buffer.write(SLASH);
        buffer.write(finalObj.getSubject().getDescription());
        buffer.write(SLASH);
        buffer.write(finalObj.getStudent().getFullName());
        buffer.write(SLASH);
        buffer.write(valueOf(finalObj.getDate()));
        buffer.write(SLASH);
        buffer.write(valueOf(finalObj.getQualification().number));
        buffer.newLine();
      }
    } catch(IOException ex) {
      throw new ReportException();
    }
  }

}
