package ar.com.unpaz.gestionfinales.usecase.students;

import java.io.File;
import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.report.AppReportContext;
import ar.com.unpaz.gestionfinales.report.ReportException;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportStudentUseCase implements DialogController {

  @Override
  public void accept() {
    try {
      File file = AppViewContext.reportStudentDialog.getFile();
      List<Student> all = AppRepositoryContext.studentRepository.getAll();
      AppReportContext.studentReport.generateReport(file , all);
      AppViewContext.appView.showMessage("Reporte de Alumnos Generado");
    } catch (ReportException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void cancel() {
    AppViewContext.reportSubjectDialog.close();
  }

}
