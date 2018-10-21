package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.console.AboutDialogConsole;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.jasper.finals.FinalJasperReport;
import ar.com.unpaz.gestionfinales.jasper.students.StudentJasperReport;
import ar.com.unpaz.gestionfinales.jasper.subjects.SubjectJasperReport;
import ar.com.unpaz.gestionfinales.mysql.finals.MySqlFinalRepository;
import ar.com.unpaz.gestionfinales.mysql.students.MySqlStudentRepository;
import ar.com.unpaz.gestionfinales.mysql.subjects.MySqlSubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.reports.AppReportContext;
import ar.com.unpaz.gestionfinales.swing.AppViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.AddFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.DeleteFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.FinalViewSwing;
import ar.com.unpaz.gestionfinales.swing.finals.ReportFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.finals.UpdateFinalDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.AddStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.DeleteStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.SelectStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.students.StudentsViewSwing;
import ar.com.unpaz.gestionfinales.swing.students.UpdateStudentDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.AddSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.DeleteSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.ReportSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SelectSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.SubjectsViewSwing;
import ar.com.unpaz.gestionfinales.swing.subjects.UpdateSubjectDialogSwing;
import ar.com.unpaz.gestionfinales.usecase.AppControllerContext;
import ar.com.unpaz.gestionfinales.usecase.AppControllerImpl;
import ar.com.unpaz.gestionfinales.usecase.finals.FinalUseCasesImpl;
import ar.com.unpaz.gestionfinales.usecase.students.StudentUseCasesImpl;
import ar.com.unpaz.gestionfinales.usecase.subjects.SubjecUseCasesImpl;

public class Main {

  public static void main(String[] args) {
        
    AppRepositoryContext.subjectRepository = new MySqlSubjectRepository();
    AppRepositoryContext.studentRepository = new MySqlStudentRepository();
    AppRepositoryContext.finalRepository = new MySqlFinalRepository();

    AppReportContext.subjectReport = new SubjectJasperReport();
    AppReportContext.studentReport = new StudentJasperReport();
    AppReportContext.finalReport = new FinalJasperReport();
    
    AppViewContext.appView = new AppViewSwing();
    AppViewContext.subjectsView = new SubjectsViewSwing();
    AppViewContext.addSubjectDialog = new AddSubjectDialogSwing();
    AppViewContext.updSubjectDialog = new UpdateSubjectDialogSwing();
    AppViewContext.delSubjectDialog = new DeleteSubjectDialogSwing();
    AppViewContext.reportSubjectDialog = new ReportSubjectDialogSwing();
    AppViewContext.aboutDialog = new AboutDialogConsole();

    AppViewContext.studentsView = new StudentsViewSwing();
    AppViewContext.addStudentDialog = new AddStudentDialogSwing();
    AppViewContext.updStudentDialog = new UpdateStudentDialogSwing();
    AppViewContext.delStudentDialog = new DeleteStudentDialogSwing();
    AppViewContext.reportStudentDialog = new ReportSubjectDialogSwing();

    AppViewContext.finalsView = new FinalViewSwing();
    AppViewContext.addFinalDialog = new AddFinalDialogSwing();
    AppViewContext.updFinalDialog = new UpdateFinalDialogSwing();
    AppViewContext.delFinalDialog = new DeleteFinalDialogSwing();
    AppViewContext.selectStudentDialog = new SelectStudentDialogSwing();
    AppViewContext.selectSubjectDialog = new SelectSubjectDialogSwing();
    AppViewContext.reportFinalDialog = new ReportFinalDialogSwing();

    AppControllerContext.appController = new AppControllerImpl();
    AppControllerContext.subjectController = new SubjecUseCasesImpl();
    AppControllerContext.studentController = new StudentUseCasesImpl();
    AppControllerContext.finalController = new FinalUseCasesImpl();

    AppControllerContext.appController.startApp();

  }
}
