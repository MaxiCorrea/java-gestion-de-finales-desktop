package ar.com.unpaz.gestionfinales.usecase.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.SubjectValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateSubjectUseCase extends SkeletonSubjectUseCase {

  public UpdateSubjectUseCase() {
    this(new SubjectValidator());
  }

  public UpdateSubjectUseCase(Validator<Subject> validator) {
    super(validator);
  }

  @Override
  Subject getTheSubjectOfTheDialog() {
    return AppViewContext.updSubjectDialog.getSubject();
  }

  @Override
  void executeAction(Subject subject) {
    AppRepositoryContext.subjectRepository.update(subject);
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.subjectsView.setSubjects(all);
    AppViewContext.updSubjectDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {
    AppViewContext.updSubjectDialog.showError(errorMessage);
  }

  @Override
  void cancelAction() {
    AppViewContext.updSubjectDialog.close();
  }

}
