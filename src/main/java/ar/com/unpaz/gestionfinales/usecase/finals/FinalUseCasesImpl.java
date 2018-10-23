package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.UseCases;

public class FinalUseCasesImpl implements UseCases<Final> {

  public FinalUseCasesImpl() {
    AppViewContext.addFinalDialog.setController(new AddFinalUseCase());
    AppViewContext.delFinalDialog.setController(new DeleteFinalUseCase());
    AppViewContext.updFinalDialog.setController(new UpdateFinalUseCase());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
  }

  @Override
  public void add() {
    AppViewContext.addFinalDialog.setFinal(Final.EMPTY);
    AppViewContext.addFinalDialog.showError("");
    AppViewContext.addFinalDialog.show();
  }

  @Override
  public void delete() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.delFinalDialog.setFinal(finalObj);
      AppViewContext.delFinalDialog.show();
    }
  }

  @Override
  public void update() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.updFinalDialog.setFinal(finalObj);
      AppViewContext.updFinalDialog.showError("");
      AppViewContext.updFinalDialog.show();
    }
  }

  @Override
  public void report() {
    AppViewContext.reportFinalDialog.show();
  }
}
