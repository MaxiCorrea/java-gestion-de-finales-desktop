package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCases;
import ar.com.unpaz.gestionfinales.usecase.selectors.AddSelectorStudent;
import ar.com.unpaz.gestionfinales.usecase.selectors.AddSelectorSubject;
import ar.com.unpaz.gestionfinales.usecase.selectors.UpdSelectorStudent;
import ar.com.unpaz.gestionfinales.usecase.selectors.UpdSeletorSubject;

public class FinalUseCases extends SkeletonUseCases<Final> {

  {
    AppViewContext.addFinalDialog.setController(new AddFinalUseCase());
    AppViewContext.delFinalDialog.setController(new DeleteFinalUseCase());
    AppViewContext.updFinalDialog.setController(new UpdateFinalUseCase());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
    AppViewContext.addSelectStudentDialog.setController(new AddSelectorStudent());
    AppViewContext.addSelectSubjectDialog.setController(new AddSelectorSubject());
    AppViewContext.updSelectStudentDialog.setController(new UpdSelectorStudent());
    AppViewContext.updSelectSubjectDialog.setController(new UpdSeletorSubject());
  }

  public FinalUseCases() {
    super(AppViewContext.addFinalDialog, 
          AppViewContext.delFinalDialog,
          AppViewContext.updFinalDialog, 
          AppViewContext.reportFinalDialog, 
          AppViewContext.finalsView);
  }

  @Override
  public void add() {
    AppViewContext.addFinalDialog.set(Final.EMPTY);
    super.add();
  }

}
