package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext;
import ar.com.unpaz.gestionfinales.presentation.controller.impl.SubjecControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AddNewSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.DeleteSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SubjectsViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.UpdateSubjectDialogSwing;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    AppViewContext.subjectView = new SubjectsViewSwing();
    AppViewContext.addSubjectDialog = new AddNewSubjectDialogSwing();
    AppViewContext.updSubjectDialog = new UpdateSubjectDialogSwing();
    AppViewContext.delSubjectDialog = new DeleteSubjectDialogSwing();
    AppControllerContext.subjectController = new SubjecControllerImpl();
    new AppViewSwing();

  }
}
