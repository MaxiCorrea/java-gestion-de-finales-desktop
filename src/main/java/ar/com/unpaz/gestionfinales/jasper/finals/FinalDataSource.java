package ar.com.unpaz.gestionfinales.jasper;

import java.util.ArrayList;
import java.util.Collection;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FinalDataSource {

  public JRDataSource createReportDataSource() {
    return new JRBeanCollectionDataSource(getBeanCollection());
  }

  Collection<FinalDataAdapter> getBeanCollection() {
    Collection<FinalDataAdapter> finals = new ArrayList<>();
    for (Final finalObj : AppRepositoryContext.finalRepository.getAll()) {
      finals.add(new FinalDataAdapter(finalObj));
    }
    if(finals.isEmpty()) {
      finals.add(new FinalDataAdapter());
    }
    return finals;
  }
  
}
