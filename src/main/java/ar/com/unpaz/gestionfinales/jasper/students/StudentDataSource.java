package ar.com.unpaz.gestionfinales.jasper.students;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class StudentDataSource {

  public JRDataSource createReportDataSource(List<Student> all) {
    Collection<StudentDataAdapter> students = new ArrayList<>();
    for (Student student : AppRepositoryContext.studentRepository.getAll()) {
      students.add(new StudentDataAdapter(student));
    }
    if(students.isEmpty()) {
      students.add(new StudentDataAdapter());
    }
    return new JRBeanCollectionDataSource(students);
  }

}
