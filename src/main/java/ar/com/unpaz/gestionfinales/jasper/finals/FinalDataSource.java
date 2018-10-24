package ar.com.unpaz.gestionfinales.jasper.finals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ar.com.unpaz.gestionfinales.domain.Final;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class FinalDataSource {

  public JRDataSource createReportDataSource(List<Final> all) {
    Collection<FinalDataAdapter> finals = new ArrayList<>();
    for (Final finalObj : all) {
      finals.add(new FinalDataAdapter(finalObj));
    }
    if (finals.isEmpty()) {
      finals.add(new FinalDataAdapter());
    }
    return new JRBeanCollectionDataSource(finals);
  }

}
