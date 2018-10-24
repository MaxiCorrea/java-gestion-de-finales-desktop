package ar.com.unpaz.gestionfinales.jasper.subjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Subject;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SubjectDataSource {

  public JRDataSource createReportDataSource(List<Subject> all) {
    Collection<SubjectDataAdapter> subjets = new ArrayList<>();
    for (Subject subject : all) {
      subjets.add(new SubjectDataAdapter(subject));
    }
    if (subjets.isEmpty()) {
      subjets.add(new SubjectDataAdapter());
    }
    return new JRBeanCollectionDataSource(subjets);
  }

}
