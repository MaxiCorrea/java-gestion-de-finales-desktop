package ar.com.unpaz.gestionfinales.usecase;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.EntityRepository;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.presentation.View;
import ar.com.unpaz.gestionfinales.validation.Validator;

public abstract class SkeletonUseCase<E> implements DialogController {

  private final Validator<E> validator;
  private final View<E> views;
  private final Dialog<E> dialog;
  private final EntityRepository<E> repository;

  public SkeletonUseCase(Validator<E> validator, 
                         View<E> views, 
                         Dialog<E> dialog,
                         EntityRepository<E> repository) {
    
    this.validator = validator;
    this.views = views;
    this.dialog = dialog;    
    this.repository = repository;
  }
 
  @Override
  public void accept() {
    E entity = dialog.get();
    if (validator.isValid(entity)) {
      execute(entity);
      List<E> all = repository.getAll();
      views.set(all);
      dialog.close();
    } else {
      String message = validator.getErrorMessage();
      dialog.showError(message);
    }
  }

  public abstract void execute(E entity);

  @Override
  public void cancel() {
    dialog.close();
  }

}
