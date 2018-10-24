package ar.com.unpaz.gestionfinales.usecase.subjects;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.SubjectValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddSubjectUseCase extends SkeletonUseCase<Subject> {

  public AddSubjectUseCase() {
    this(new SubjectValidator());
  }
  
  public AddSubjectUseCase(Validator<Subject> validator) {
    super(validator, 
          AppViewContext.subjectsView ,
          AppViewContext.addSubjectDialog,
          AppRepositoryContext.subjectRepository);
  }

  @Override
  public void execute(Subject entity) {
    AppRepositoryContext.subjectRepository.add(entity);
  }

}
