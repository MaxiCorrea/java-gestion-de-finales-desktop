package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.SkeletonUseCase;
import ar.com.unpaz.gestionfinales.validation.NullValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class DeleteFinalUseCase extends SkeletonUseCase<Final> {

  public DeleteFinalUseCase() {
    this(new NullValidator<>());
  }
  
  public DeleteFinalUseCase(Validator<Final> validator) {
    super(validator,
          AppViewContext.finalsView ,
          AppViewContext.delFinalDialog ,
          AppRepositoryContext.finalRepository);
  }

  @Override
  public void execute(Final entity) {
    AppRepositoryContext.finalRepository.remove(entity);
  }

}