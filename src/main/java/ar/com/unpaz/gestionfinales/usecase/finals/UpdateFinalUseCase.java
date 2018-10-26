package ar.com.unpaz.gestionfinales.usecase.finals;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.FinalValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateFinalUseCase extends SkeletonUseCase<Final> implements FinalDialogController {

  public UpdateFinalUseCase() {
    this(new FinalValidator());
  }

  public UpdateFinalUseCase(Validator<Final> validator) {
    super(validator, AppViewContext.finalsView, AppViewContext.updFinalDialog,
        AppRepositoryContext.finalRepository);
  }

  @Override
  public void selectStudent() {
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.updSelectStudentDialog.set(all);
    AppViewContext.updSelectStudentDialog.show();
  }

  @Override
  public void selectSubject() {
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.updSelectSubjectDialog.set(all);
    AppViewContext.updSelectSubjectDialog.show();
  }

  @Override
  public void execute(Final entity) {
    AppRepositoryContext.finalRepository.update(entity);
  }

}
