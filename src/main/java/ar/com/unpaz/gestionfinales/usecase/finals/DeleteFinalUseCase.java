package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public  class DeleteFinalUseCase implements DialogController {

  @Override
  public void accept() {
    Final finalObject = AppViewContext.delFinalDialog.getFinal();
    AppRepositoryContext.finalRepository.remove(finalObject);
    AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
    AppViewContext.delFinalDialog.close();
  }

  @Override
  public void cancel() {
    AppViewContext.delFinalDialog.close();
  }

}