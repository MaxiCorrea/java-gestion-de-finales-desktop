package ar.com.unpaz.gestionfinales.plaintext;

import static java.lang.String.valueOf;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextSubjectReport implements Report {

  private static final String SLASH = "/";
  
  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try (FileWriter out = new FileWriter(absolutePath);
        BufferedWriter buffer = new BufferedWriter(out)) {
      for (Subject subject : AppRepositoryContext.subjectRepository.getAll()) {
        buffer.write(valueOf(subject.getId()));
        buffer.write(SLASH);
        buffer.write(subject.getDescription());
        buffer.write(SLASH);
        buffer.write(valueOf(subject.getYear().number));
        buffer.write(SLASH);
        buffer.newLine();
      }
    } catch (IOException exception) {
      throw new ReportException();
    }
  }

}
