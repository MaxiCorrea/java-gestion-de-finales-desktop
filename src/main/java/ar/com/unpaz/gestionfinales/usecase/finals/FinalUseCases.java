package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCases;

public class FinalUseCases extends SkeletonUseCases<Final> {

  {
    AppViewContext.addFinalDialog.setController(new AddFinalUseCase());
    AppViewContext.delFinalDialog.setController(new DeleteFinalUseCase());
    AppViewContext.updFinalDialog.setController(new UpdateFinalUseCase());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
    AppViewContext.addSelectStudentDialog.setController(
        new StudentSelection(AppViewContext.addSelectStudentDialog, AppViewContext.addFinalDialog));
    AppViewContext.addSelectSubjectDialog.setController(
        new SubjectSelection(AppViewContext.addSelectSubjectDialog, AppViewContext.addFinalDialog));
    AppViewContext.updSelectSubjectDialog.setController(
        new StudentSelection(AppViewContext.updSelectStudentDialog, AppViewContext.updFinalDialog));
    AppViewContext.updSelectStudentDialog.setController(
        new SubjectSelection(AppViewContext.updSelectSubjectDialog, AppViewContext.updFinalDialog));

  }

  public FinalUseCases() {
    super(AppViewContext.addFinalDialog, AppViewContext.delFinalDialog,
        AppViewContext.updFinalDialog, AppViewContext.reportFinalDialog, AppViewContext.finalsView);
  }

  @Override
  public void add() {
    AppViewContext.addFinalDialog.set(Final.EMPTY);
    super.add();
  }

}
