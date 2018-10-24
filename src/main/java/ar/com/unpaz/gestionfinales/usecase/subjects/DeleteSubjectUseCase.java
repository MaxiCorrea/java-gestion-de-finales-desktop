package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.NullValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteSubjectUseCase extends SkeletonUseCase<Subject> {

  public DeleteSubjectUseCase() {
    this(new NullValidator<>());
  }

  public DeleteSubjectUseCase(Validator<Subject> validator) {
    super(validator,
          AppViewContext.subjectsView ,
          AppViewContext.delSubjectDialog,
          AppRepositoryContext.subjectRepository);
  }

  @Override
  public void execute(Subject entity) {
    AppRepositoryContext.subjectRepository.remove(entity);
  }
  
}
