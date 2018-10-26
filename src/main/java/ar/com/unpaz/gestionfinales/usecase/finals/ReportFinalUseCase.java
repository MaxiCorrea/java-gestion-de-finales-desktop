package ar.com.unpaz.gestionfinales.usecase.finals;

import java.io.File;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.report.AppReportContext;
import ar.com.unpaz.gestionfinales.report.ReportException;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportFinalUseCase implements DialogController {

  @Override
  public void accept() {
    try {
      File file = AppViewContext.reportFinalDialog.getFile();
      List<Final> all = AppRepositoryContext.finalRepository.getAll();
      AppReportContext.finalReport.generateReport(file, all);
    } catch (ReportException e) {
      AppViewContext.appView.showError(e.getMessage());
    }
  }

  @Override
  public void cancel() {
    AppViewContext.reportFinalDialog.close();
  }

}
