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

public class AddFinalUseCase extends SkeletonUseCase<Final> implements FinalDialogController {

  public AddFinalUseCase() {
    this(new FinalValidator());
  }

  public AddFinalUseCase(Validator<Final> validator) {
    super(validator,
        AppViewContext.finalsView,
        AppViewContext.addFinalDialog,
        AppRepositoryContext.finalRepository);
  }

  @Override
  public void selectStudent() {
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.selectStudentDialog.set(all);
    AppViewContext.selectStudentDialog.show();
  }

  @Override
  public void selectSubject() {
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.selectSubjectDialog.set(all);
    AppViewContext.selectSubjectDialog.show();
  }

  @Override
  public void execute(Final entity) {
    AppRepositoryContext.finalRepository.add(entity);
  }

}
