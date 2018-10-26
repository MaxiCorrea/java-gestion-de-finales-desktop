package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.console.AboutDialogConsole;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.inmemory.InMemoryFinalRepository;
import ar.com.unpaz.gestionfinales.inmemory.InMemoryStudentRepository;
import ar.com.unpaz.gestionfinales.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.jasper.finals.FinalJasperReport;
import ar.com.unpaz.gestionfinales.jasper.students.StudentJasperReport;
import ar.com.unpaz.gestionfinales.jasper.subjects.SubjectJasperReport;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.report.AppReportContext;
import ar.com.unpaz.gestionfinales.swing.AppViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.AddFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.DeleteFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.FinalViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.ReportFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.UpdateFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.SelectStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.ReportStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.StudentDialogDataFor;
import ar.com.unpaz.gestionfinales.swing.students.StudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.StudentsViewSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SelectSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.ReportSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SubjectDialogDataFor;
import ar.com.unpaz.gestionfinales.swing.subjects.SubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SubjectsViewSwing;
import ar.com.unpaz.gestionfinales.usecase.AppControllerContext;
import ar.com.unpaz.gestionfinales.usecase.AppControllerImpl;
import ar.com.unpaz.gestionfinales.usecase.finals.FinalUseCases;
import ar.com.unpaz.gestionfinales.usecase.students.StudentUseCases;
import ar.com.unpaz.gestionfinales.usecase.subjects.SubjecUseCases;

public class Main {

  public static void main(String[] args) {

    AppRepositoryContext.subjectRepository = new InMemorySubjectRepository();
    AppRepositoryContext.studentRepository = new InMemoryStudentRepository();
    AppRepositoryContext.finalRepository = new InMemoryFinalRepository();

    AppReportContext.subjectReport = new SubjectJasperReport();
    AppReportContext.studentReport = new StudentJasperReport();
    AppReportContext.finalReport = new FinalJasperReport();

    AppViewContext.appView = new AppViewSwing();
    AppViewContext.subjectsView = new SubjectsViewSwing();
    AppViewContext.addSubjectDialog = new SubjectDialogSwing(SubjectDialogDataFor.ADD);
    AppViewContext.updSubjectDialog = new SubjectDialogSwing(SubjectDialogDataFor.UPDATE);
    AppViewContext.delSubjectDialog = new SubjectDialogSwing(SubjectDialogDataFor.DELETE);
    AppViewContext.reportSubjectDialog = new ReportSubjectDialogSwing();
    AppViewContext.aboutDialog = new AboutDialogConsole();

    AppViewContext.studentsView = new StudentsViewSwing();
    AppViewContext.addStudentDialog = new StudentDialogSwing(StudentDialogDataFor.ADD);
    AppViewContext.updStudentDialog = new StudentDialogSwing(StudentDialogDataFor.UPDATE);
    AppViewContext.delStudentDialog = new StudentDialogSwing(StudentDialogDataFor.DELETE);
    AppViewContext.reportStudentDialog = new ReportStudentDialogSwing();

    AppViewContext.finalsView = new FinalViewSwing();
    AppViewContext.addFinalDialog = new AddFinalDialogSwing();
    AppViewContext.updFinalDialog = new UpdateFinalDialogSwing();
    AppViewContext.delFinalDialog = new DeleteFinalDialogSwing();
    AppViewContext.addSelectStudentDialog = new SelectStudentDialogSwing();
    AppViewContext.addSelectSubjectDialog = new SelectSubjectDialogSwing();
    AppViewContext.updSelectStudentDialog = new SelectStudentDialogSwing();
    AppViewContext.updSelectSubjectDialog = new SelectSubjectDialogSwing();

    AppViewContext.reportFinalDialog = new ReportFinalDialogSwing();

    AppControllerContext.appController = new AppControllerImpl();
    AppControllerContext.subjectUseCases = new SubjecUseCases();
    AppControllerContext.studentUseCases = new StudentUseCases();
    AppControllerContext.finalUseCases = new FinalUseCases();

    AppControllerContext.appController.startApp();

  }
}
