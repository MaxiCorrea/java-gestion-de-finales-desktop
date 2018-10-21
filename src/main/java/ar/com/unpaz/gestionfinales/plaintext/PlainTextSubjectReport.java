package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextSubjectReport implements Report {

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try (FileWriter out = new FileWriter(absolutePath);
        BufferedWriter buffer = new BufferedWriter(out)) {
      for (Subject subject : AppRepositoryContext.subjectRepository.getAll()) {
        buffer.write(formatString(subject));
        buffer.newLine();
      }
    } catch (IOException exception) {
      throw new ReportException();
    }
  }

  private static final String SLASH = "/";

  String formatString(Subject subject) {
    return new StringBuilder().append(subject.getId())
                              .append(SLASH)
                              .append(subject.getDescription())
                              .append(SLASH)
                              .append(subject.getYear().number)
                              .append(SLASH)
                              .toString();
  }
  
}
