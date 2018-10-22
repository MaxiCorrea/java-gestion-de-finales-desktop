package ar.com.unpaz.gestionfinales.usecase.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.NoSubjectValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteSubjectUseCase extends SkeletonSubjectUseCase {

  public DeleteSubjectUseCase() {
    this(new NoSubjectValidator());
  }

  public DeleteSubjectUseCase(Validator<Subject> validator) {
    super(validator);
  }

  @Override
  Subject getTheSubjectOfTheDialog() {
    return AppViewContext.delSubjectDialog.getSubject();
  }

  @Override
  void executeAction(Subject subject) {
    AppRepositoryContext.subjectRepository.remove(subject);
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.subjectsView.setSubjects(all);
    AppViewContext.delSubjectDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {}

  @Override
  void cancelAction() {
    AppViewContext.delSubjectDialog.close();
  }

}
