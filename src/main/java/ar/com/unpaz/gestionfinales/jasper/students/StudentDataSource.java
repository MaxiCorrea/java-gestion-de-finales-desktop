package ar.com.unpaz.gestionfinales.jasper.students;

import java.util.ArrayList;
import java.util.Collection;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class StudentDataSource {

  public JRDataSource createReportDataSource() {
    return new JRBeanCollectionDataSource(getBeanCollection());
  }

  Collection<StudentDataAdapter> getBeanCollection() {
    Collection<StudentDataAdapter> students = new ArrayList<>();
    for (Student student : AppRepositoryContext.studentRepository.getAll()) {
      students.add(new StudentDataAdapter(student));
    }
    if(students.isEmpty()) {
      students.add(new StudentDataAdapter());
    }
    return students;
  }

}
