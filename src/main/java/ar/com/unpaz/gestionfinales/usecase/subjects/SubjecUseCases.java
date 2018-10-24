package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCases;

public class SubjecUseCases extends SkeletonUseCases<Subject> {

  {
    AppViewContext.addSubjectDialog.setController(new AddSubjectUseCase());
    AppViewContext.updSubjectDialog.setController(new UpdateSubjectUseCase());
    AppViewContext.delSubjectDialog.setController(new DeleteSubjectUseCase());
    AppViewContext.reportSubjectDialog.setController(new ReportSubjectUseCase());
  }
  
  public SubjecUseCases() {    
    super(AppViewContext.addSubjectDialog,
          AppViewContext.delSubjectDialog, 
          AppViewContext.updSubjectDialog,
          AppViewContext.reportSubjectDialog,
          AppViewContext.subjectsView);
  }
  
  @Override
  public void add() {
    AppViewContext.addSubjectDialog.set(Subject.EMPTY);
    super.add();
  }

}
