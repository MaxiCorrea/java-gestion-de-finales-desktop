package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.report.Report;
import ar.com.unpaz.gestionfinales.report.ReportException;

public class PlainTextStudentReport implements Report {

  private static final String SLASH = "/";
  
  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try(FileWriter out = new FileWriter(absolutePath) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Student student : AppRepositoryContext.studentRepository.getAll()) {
        buffer.write(String.valueOf(student.getId()));
        buffer.write(SLASH);
        buffer.write(student.getName());
        buffer.write(SLASH);
        buffer.write(student.getSurname());
        buffer.write(SLASH);
        buffer.write(student.getEmail());
        buffer.newLine();
      }
    } catch(IOException ex) {
      throw new ReportException();
    }
  }

}
