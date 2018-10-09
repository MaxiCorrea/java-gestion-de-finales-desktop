package ar.com.unpaz.gestionfinales.presentation.controller.impl;

import static ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext.subjectRepository;
import static ar.com.unpaz.gestionfinales.presentation.view.AppViewContext.subjectView;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.SubjectController;

public class SubjecControllerImpl implements SubjectController {

  @Override
  public void addSubject() {
    subjectView.clearDescription();
    subjectView.resetYear();
    subjectView.showDialog();
  }

  @Override
  public void deleteSubject() {

  }

  @Override
  public void updateSubject() {

  }

  @Override
  public void filterByYear() {
    
  }

  @Override
  public void save() {
    if (!subjectView.getDescription().trim().isEmpty()) {
      String description = subjectView.getDescription();
      int year = subjectView.getYear();
      subjectRepository.addSubject(new Subject(description, year));
      subjectView.update(subjectRepository.getAll());
      subjectView.closeDialog();
    } else {
      subjectView.message("Campo descripcion vacio");
    }
  }

  @Override
  public void cancel() {
    subjectView.closeDialog();
  }

}
