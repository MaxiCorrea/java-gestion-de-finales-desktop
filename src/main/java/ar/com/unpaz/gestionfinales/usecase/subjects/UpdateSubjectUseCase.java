package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.SubjectValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateSubjectUseCase extends SkeletonUseCase<Subject> {

  public UpdateSubjectUseCase() {
    this(new SubjectValidator());
  }

  public UpdateSubjectUseCase(Validator<Subject> validator) {
    super(validator,
        AppViewContext.subjectsView,
        AppViewContext.updSubjectDialog,
        AppRepositoryContext.subjectRepository);
  }

  @Override
  public void execute(Subject entity) {
    AppRepositoryContext.subjectRepository.update(entity);
  }
  
}
