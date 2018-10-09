package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext;
import ar.com.unpaz.gestionfinales.presentation.controller.impl.SubjecControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AppViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SubjectsViewSwing;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    
    AppControllerContext.subjectController = new SubjecControllerImpl();

    AppViewContext.subjectView = new SubjectsViewSwing();

    new AppViewSwing();

  }
}
