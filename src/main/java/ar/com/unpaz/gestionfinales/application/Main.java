package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext;
import ar.com.unpaz.gestionfinales.presentation.controller.StudentControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.controller.SubjecControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.controller.SubjectAddDialogControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AppViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.StudentsViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SubjectAddDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SubjectsViewSwing;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    AppControllerContext.subjectController = new SubjecControllerImpl();
    AppControllerContext.studentController = new StudentControllerImpl();
    AppControllerContext.subjectAddDialogController = new SubjectAddDialogControllerImpl();
    AppPresentationContext.subjectView = new SubjectsViewSwing();
    AppPresentationContext.studentView = new StudentsViewSwing();
    AppPresentationContext.subjectAddDialog = new SubjectAddDialogSwing();

    new AppViewSwing();

  }
}
