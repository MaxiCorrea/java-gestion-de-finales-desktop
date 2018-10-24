package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextStudentReport implements Report<Student> {

  @Override
  public void generateReport(File file, List<Student> all) throws ReportException {
    try(FileWriter out = new FileWriter(file) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Student student : all) {
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
