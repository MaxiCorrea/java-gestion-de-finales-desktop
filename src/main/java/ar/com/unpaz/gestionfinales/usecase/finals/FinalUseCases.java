package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCases;

public class FinalUseCases extends SkeletonUseCases<Final> {

  {
    AppViewContext.addFinalDialog.setController(new AddFinalUseCase());
    AppViewContext.delFinalDialog.setController(new DeleteFinalUseCase());
    AppViewContext.updFinalDialog.setController(new UpdateFinalUseCase());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
    AppViewContext.selectStudentDialog.setController(new StudentSelection());
    AppViewContext.selectSubjectDialog.setController(new SubjectSelection());
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

  private class StudentSelection implements DialogController {

    @Override
    public void accept() {
      if (AppViewContext.selectStudentDialog.getSelectedRow() != -1) {
        int row = AppViewContext.selectStudentDialog.getSelectedRow();
        Student student = AppViewContext.selectStudentDialog.getInRow(row);
        Final f = AppViewContext.addFinalDialog.get();
        Final f2 = new Final(f.getId() , f.getSubject() , student ,
            f.getDate() , f.getQualification());
        AppViewContext.addFinalDialog.set(f2);
        AppViewContext.selectStudentDialog.close();
      }
    }

    @Override
    public void cancel() {
      AppViewContext.selectStudentDialog.close();
    }
    
  }
  
  private class SubjectSelection implements DialogController {

    @Override
    public void accept() {
      if (AppViewContext.selectSubjectDialog.getSelectedRow() != -1) {
        int row = AppViewContext.selectSubjectDialog.getSelectedRow();
        Subject subject = AppViewContext.selectSubjectDialog.getInRow(row);
        Final f = AppViewContext.addFinalDialog.get();
        Final f2 = new Final(f.getId(), subject, f.getStudent(), 
            f.getDate(), f.getQualification());
        AppViewContext.addFinalDialog.set(f2);
        AppViewContext.selectSubjectDialog.close();
      }
    }

    @Override
    public void cancel() {
      AppViewContext.selectSubjectDialog.close();
    }

  }
  
}
