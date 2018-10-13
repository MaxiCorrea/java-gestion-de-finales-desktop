package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.inmemory.finals.InMemoryFinalRepository;
import ar.com.unpaz.gestionfinales.inmemory.students.InMemoryStudentRepository;
import ar.com.unpaz.gestionfinales.inmemory.subjects.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.swing.AppViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.AddFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.DeleteFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.FinalViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.UpdateFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.AddStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.DeleteStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.SelectStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.StudentsViewSwing;
import ar.com.unpaz.gestionfinales.swing.students.UpdateStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.AddSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.DeleteSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SelectSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SubjectsViewSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.UpdateSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.usecase.AppControllerImpl;
import ar.com.unpaz.gestionfinales.usecase.finals.FinalControllerImpl;
import ar.com.unpaz.gestionfinales.usecase.students.StudentControllerImpl;
import ar.com.unpaz.gestionfinales.usecase.subjects.SubjecControllerImpl;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    AppRepositoryContext.studentRepository = new InMemoryStudentRepository();
    AppRepositoryContext.finalRepository = new InMemoryFinalRepository();
    
    AppViewContext.appView = new AppViewSwing();
    
    AppViewContext.subjectsView = new SubjectsViewSwing();
    AppViewContext.addSubjectDialog = new AddSubjectDialogSwing();
    AppViewContext.updSubjectDialog = new UpdateSubjectDialogSwing();
    AppViewContext.delSubjectDialog = new DeleteSubjectDialogSwing();
    
    AppViewContext.studentsView = new StudentsViewSwing();
    AppViewContext.addStudentDialog = new AddStudentDialogSwing();
    AppViewContext.updStudentDialog = new UpdateStudentDialogSwing();
    AppViewContext.delStudentDialog = new DeleteStudentDialogSwing();
    
    AppViewContext.finalsView = new FinalViewSwing();
    AppViewContext.addFinalDialog = new AddFinalDialogSwing();
    AppViewContext.updFinalDialog = new UpdateFinalDialogSwing();
    AppViewContext.delFinalDialog = new DeleteFinalDialogSwing();
    AppViewContext.selectStudentDialog = new SelectStudentDialogSwing();
    AppViewContext.selectSubjectDialog = new SelectSubjectDialogSwing();

    AppControllerContext.appController = new AppControllerImpl(AppViewContext.appView ,
                                                               AppViewContext.subjectsView ,
                                                               AppRepositoryContext.subjectRepository ,
                                                               AppViewContext.studentsView ,
                                                               AppRepositoryContext.studentRepository ,
                                                               AppViewContext.finalsView ,
                                                               AppRepositoryContext.finalRepository);
    
    AppViewContext.appView.setController(AppControllerContext.appController);
    
    AppControllerContext.subjectController = new SubjecControllerImpl();
    AppControllerContext.studentController = new StudentControllerImpl();
    AppControllerContext.finalController = new FinalControllerImpl();
    
    AppControllerContext.appController.startApp();

  }
}
