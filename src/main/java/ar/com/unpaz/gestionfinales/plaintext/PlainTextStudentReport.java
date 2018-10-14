package ar.com.unpaz.gestionfinales.plaintext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.reports.Report;
import ar.com.unpaz.gestionfinales.reports.ReportException;

public class PlainTextStudentReport implements Report {

  @Override
  public void generateReport(String absolutePath) throws ReportException {
    try(FileWriter out = new FileWriter(absolutePath) ;
        BufferedWriter buffer = new BufferedWriter(out)) {
      for(Student student : AppRepositoryContext.studentRepository.getAll()) {
        buffer.write(String.valueOf(student.getId()));
        buffer.write("\t");
        buffer.write(student.getName());
        buffer.write("\t");
        buffer.write(student.getSurname());
        buffer.write("\t");
        buffer.write(student.getEmail());
        buffer.newLine();
      }
    } catch(IOException ex) {
      throw new ReportException();
    }
  }

}
