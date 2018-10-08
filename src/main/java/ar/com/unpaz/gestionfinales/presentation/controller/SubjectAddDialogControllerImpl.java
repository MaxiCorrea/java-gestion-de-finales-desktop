package ar.com.unpaz.gestionfinales.presentation.controller;

import static ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext.subjectRepository;
import static ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext.subjectAddDialog;
import static ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext.subjectView;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class SubjectAddDialogControllerImpl implements SubjectAddDialogController {

  @Override
  public void save() {
    if (!subjectAddDialog.getDescription().trim().isEmpty()) {
      String description = subjectAddDialog.getDescription();
      int year = subjectAddDialog.getYear();
      subjectRepository.addSubject(new Subject(description, year));
      subjectView.update(subjectRepository.getAll());
      subjectAddDialog.close();
    } else {
      subjectAddDialog.message("Campo descripcion vacio");
    }
  }

  @Override
  public void cancel() {
    subjectAddDialog.close();
  }

}
