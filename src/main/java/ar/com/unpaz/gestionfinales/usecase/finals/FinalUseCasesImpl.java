package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class FinalUseCasesImpl implements FinalUseCases {

  public FinalUseCasesImpl() {
    AppViewContext.addFinalDialog.setController(new AddFinalUseCase());
    AppViewContext.delFinalDialog.setController(new DeleteFinalUseCase());
    AppViewContext.updFinalDialog.setController(new UpdateFinalUseCase());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
  }

  @Override
  public void addFinal() {
    AppViewContext.addFinalDialog.setFinal(Final.EMPTY);
    AppViewContext.addFinalDialog.showError("");
    AppViewContext.addFinalDialog.show();
  }

  @Override
  public void deleteFinal() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.delFinalDialog.setFinal(finalObj);
      AppViewContext.delFinalDialog.show();
    }
  }

  @Override
  public void updateFinal() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.updFinalDialog.setFinal(finalObj);
      AppViewContext.updFinalDialog.showError("");
      AppViewContext.updFinalDialog.show();
    }
  }

  @Override
  public void generateReport() {
    AppViewContext.reportFinalDialog.show();
  }
}
