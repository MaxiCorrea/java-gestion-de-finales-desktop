package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextSubjectReport implements Report<Subject> {

  @Override
  public void generateReport(File file, List<Subject> all) throws ReportException {
    try (FileWriter out = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(out)) {
      for (Subject subject : all) {
        buffer.write(formatString(subject));
        buffer.newLine();
      }
    } catch (IOException exception) {
      throw new ReportException();
    }
  }

  private static final String SLASH = "/";

  String formatString(Subject subject) {
    return new StringBuilder().append(subject.getId()).append(SLASH)
        .append(subject.getDescription()).append(SLASH).append(subject.getYear().number)
        .append(SLASH).toString();
  }

}
