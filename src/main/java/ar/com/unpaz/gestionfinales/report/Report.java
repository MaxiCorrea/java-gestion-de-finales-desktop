package ar.com.unpaz.gestionfinales.report;

import java.io.File;
import java.util.List;

public interface Report<E> {

  void generateReport(File file , List<E> all) throws ReportException;
  
}
