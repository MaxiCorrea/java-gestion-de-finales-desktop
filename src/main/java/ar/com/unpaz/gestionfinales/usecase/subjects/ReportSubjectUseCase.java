package ar.com.unpaz.gestionfinales.usecase.subjects;

import java.io.File;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.report.AppReportContext;
import ar.com.unpaz.gestionfinales.report.ReportException;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    try {
      File file = AppViewContext.reportSubjectDialog.getFile();
      List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
      AppReportContext.subjectReport.generateReport(file, all);
    } catch (ReportException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void cancel() {
    AppViewContext.reportSubjectDialog.close();
  }

}
