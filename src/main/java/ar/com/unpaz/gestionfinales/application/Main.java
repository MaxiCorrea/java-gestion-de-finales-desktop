package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemoryFinalRepository;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemoryStudentRepository;
import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext;
import ar.com.unpaz.gestionfinales.presentation.controller.impl.FinalControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.controller.impl.StudentControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.controller.impl.SubjecControllerImpl;
import ar.com.unpaz.gestionfinales.presentation.view.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AddFinalDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AddStudentDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.AddSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.DeleteFinalDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.DeleteStudentDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.DeleteSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.FinalsViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SelectStudentDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SelectSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.StudentsViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.SubjectsViewSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.UpdateFinalDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.UpdateStudentDialogSwing;
import ar.com.unpaz.gestionfinales.presentation.view.swing.UpdateSubjectDialogSwing;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    AppRepositoryContext.studentRepository = new InMemoryStudentRepository();
    AppRepositoryContext.finalRepository = new InMemoryFinalRepository();
    
    AppViewContext.subjectView = new SubjectsViewSwing();
    AppViewContext.addSubjectDialog = new AddSubjectDialogSwing();
    AppViewContext.updSubjectDialog = new UpdateSubjectDialogSwing();
    AppViewContext.delSubjectDialog = new DeleteSubjectDialogSwing();
    
    AppViewContext.studentView = new StudentsViewSwing();
    AppViewContext.addStudentDialog = new AddStudentDialogSwing();
    AppViewContext.updStudentDialog = new UpdateStudentDialogSwing();
    AppViewContext.delStudentDialog = new DeleteStudentDialogSwing();
    
    AppViewContext.finalsView = new FinalsViewSwing();
    AppViewContext.addFinalDialog = new AddFinalDialogSwing();
    AppViewContext.updFinalDialog = new UpdateFinalDialogSwing();
    AppViewContext.delFinalDialog = new DeleteFinalDialogSwing();
    AppViewContext.selectStudentDialog = new SelectStudentDialogSwing();
    AppViewContext.selectSubjectDialog = new SelectSubjectDialogSwing();
    
    AppControllerContext.subjectController = new SubjecControllerImpl();
    AppControllerContext.studentController = new StudentControllerImpl();
    AppControllerContext.finalController = new FinalControllerImpl();
    
    new AppViewSwing();

  }
}
