package ar.com.unpaz.gestionfinales.usecase.subjects;

import java.io.File;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.report.AppReportContext;
import ar.com.unpaz.gestionfinales.report.ReportException;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportSubjectUseCase implements DialogController {

  @Override
  public void accept() {
    try {
      File file = AppViewContext.reportSubjectDialog.getFile();
      AppReportContext.subjectReport.generateReport(file.getAbsolutePath());
    } catch (ReportException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void cancel() {
    AppViewContext.reportSubjectDialog.close();
  }

}
