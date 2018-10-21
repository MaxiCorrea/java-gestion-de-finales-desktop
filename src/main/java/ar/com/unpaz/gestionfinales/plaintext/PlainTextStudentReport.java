package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextStudentReport implements Report {

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try(FileWriter out = new FileWriter(absolutePath) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Student student : AppRepositoryContext.studentRepository.getAll()) {
        buffer.write(formatString(student));
        buffer.newLine();
      }
    } catch(IOException ex) {
      throw new ReportException();
    }
  }

  private static final String SLASH = "/";
  
  String formatString(Student student) {
    return new StringBuilder().append(student.getDni())
                              .append(SLASH)
                              .append(student.getName())
                              .append(SLASH)
                              .append(student.getSurname())
                              .append(SLASH)
                              .append(student.getEmail())
                              .toString();
  }
  
}
