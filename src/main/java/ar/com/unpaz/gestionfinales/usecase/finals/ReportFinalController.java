package ar.com.unpaz.gestionfinales.usecase.finals;

import java.io.File;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.reports.AppReportContext;
import ar.com.unpaz.gestionfinales.reports.ReportException;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportFinalController implements DialogController {

  @Override
  public void accept() {
    try {
      File file = AppViewContext.reportFinalDialog.getFile();
      AppReportContext.finalReport.generateReport(file.getAbsolutePath());
    } catch (ReportException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void cancel() {
    AppViewContext.reportFinalDialog.close();
  }

}
