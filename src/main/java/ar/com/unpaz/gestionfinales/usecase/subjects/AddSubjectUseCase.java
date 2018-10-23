package ar.com.unpaz.gestionfinales.usecase.subjects;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.validation.SubjectValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddSubjectUseCase extends SkeletonSubjectUseCase {

  public AddSubjectUseCase() {
    this(new SubjectValidator());
  }

  public AddSubjectUseCase(Validator<Subject> validator) {
    super(validator);
  }

  @Override
  Subject getTheSubjectOfTheDialog() {
    return AppViewContext.addSubjectDialog.get();
  }

  @Override
  void executeAction(Subject subject) {
    AppRepositoryContext.subjectRepository.add(subject);
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.subjectsView.set(all);
    AppViewContext.addSubjectDialog.close();
  }

  @Override
  void showErrorInTheDialog(String errorMessage) {
    AppViewContext.addSubjectDialog.showError(errorMessage);
  }

  @Override
  void cancelAction() {
    AppViewContext.addSubjectDialog.close();
  }

}
