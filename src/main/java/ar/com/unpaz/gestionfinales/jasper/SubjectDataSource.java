package ar.com.unpaz.gestionfinales.jasper;

import java.util.ArrayList;
import java.util.Collection;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SubjectDataSource {

  public JRDataSource createReportDataSource() {
    return new JRBeanCollectionDataSource(getBeanCollection());
  }

  Collection<SubjectDataAdapter> getBeanCollection() {
    Collection<SubjectDataAdapter> subjets = new ArrayList<>();
    for (Subject subject : AppRepositoryContext.subjectRepository.getAll()) {
      subjets.add(new SubjectDataAdapter(subject));
    }
    if (subjets.isEmpty()) {
      subjets.add(new SubjectDataAdapter());
    }
    return subjets;
  }

}
