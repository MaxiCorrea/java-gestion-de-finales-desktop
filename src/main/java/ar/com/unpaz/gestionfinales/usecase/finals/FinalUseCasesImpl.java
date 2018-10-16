package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class FinalUseCasesImpl implements FinalUseCases {

  public FinalUseCasesImpl() {
    AppViewContext.addFinalDialog.setController(new AddFinalDialogController());
    AppViewContext.delFinalDialog.setController(new DelFinalDialogController());
    AppViewContext.updFinalDialog.setController(new UpdFinalDialogController());
    AppViewContext.selectStudentDialog.setController(new SelectStudentController());
    AppViewContext.selectSubjectDialog.setController(new SelectSubjectController());
    AppViewContext.reportFinalDialog.setController(new ReportFinalUseCase());
  }

  @Override
  public void addFinal() {
    AppViewContext.addFinalDialog.setFinal(Final.EMPTY);
    AppViewContext.addFinalDialog.showError("");
    AppViewContext.addFinalDialog.show();
  }

  @Override
  public void deleteFinal() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.delFinalDialog.setFinal(finalObj);
      AppViewContext.delFinalDialog.show();
    }
  }

  @Override
  public void updateFinal() {
    if (AppViewContext.finalsView.getSelectedRow() != -1) {
      int row = AppViewContext.finalsView.getSelectedRow();
      Final finalObj = AppViewContext.finalsView.getFinalInRow(row);
      AppViewContext.updFinalDialog.setFinal(finalObj);
      AppViewContext.updFinalDialog.show();
    }
  }

  @Override
  public void generateReport() {
    AppViewContext.reportFinalDialog.show();
  }

  private class AddFinalDialogController implements FinalDialogController {

    @Override
    public void accept() {
      Final finalObj = AppViewContext.addFinalDialog.getFinal();
      String errorMessage = Final.validateFieldsOf(finalObj);
      if (!errorMessage.isEmpty()) {
        AppViewContext.addFinalDialog.showError(errorMessage);
      } else {
        AppRepositoryContext.finalRepository.add(finalObj);
        AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
        AppViewContext.addFinalDialog.close();
      }
    }

    @Override
    public void selectStudent() {
      AppViewContext.selectStudentDialog
          .setStudents(AppRepositoryContext.studentRepository.getAll());
      AppViewContext.selectStudentDialog.show();
    }

    @Override
    public void selectSubject() {
      AppViewContext.selectSubjectDialog
          .setSubjects(AppRepositoryContext.subjectRepository.getAll());
      AppViewContext.selectSubjectDialog.show();
    }

    @Override
    public void cancel() {
      AppViewContext.addFinalDialog.close();
    }

  }

  private class DelFinalDialogController implements DialogController {

    @Override
    public void accept() {
      Final finalObject = AppViewContext.delFinalDialog.getFinal();
      AppRepositoryContext.finalRepository.remove(finalObject);
      AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
      AppViewContext.delFinalDialog.close();
    }

    @Override
    public void cancel() {
      AppViewContext.delFinalDialog.close();
    }

  }

  private class UpdFinalDialogController implements FinalDialogController {

    @Override
    public void accept() {
      Final finalObject = AppViewContext.updFinalDialog.getFinal();
      AppRepositoryContext.finalRepository.update(finalObject);
      AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
      AppViewContext.updFinalDialog.close();
    }

    @Override
    public void selectStudent() {

    }

    @Override
    public void selectSubject() {

    }

    @Override
    public void cancel() {
      AppViewContext.updFinalDialog.close();
    }

  }

  private class SelectSubjectController implements DialogController {

    @Override
    public void accept() {
      if (AppViewContext.selectSubjectDialog.getSelectedRow() != -1) {
        int row = AppViewContext.selectSubjectDialog.getSelectedRow();
        Subject subject = AppViewContext.selectSubjectDialog.getSubjectInRow(row);
        AppViewContext.addFinalDialog.setSubject(subject);
        AppViewContext.selectSubjectDialog.close();
      }
    }

    @Override
    public void cancel() {
      AppViewContext.selectSubjectDialog.close();
    }

  }

  private class SelectStudentController implements DialogController {

    @Override
    public void accept() {
      if (AppViewContext.selectStudentDialog.getSelectedRow() != -1) {
        int row = AppViewContext.selectStudentDialog.getSelectedRow();
        Student student = AppViewContext.selectStudentDialog.getStudentInRow(row);
        AppViewContext.addFinalDialog.setStudent(student);
        AppViewContext.selectStudentDialog.close();
      }
    }

    @Override
    public void cancel() {
      AppViewContext.selectStudentDialog.close();
    }

  }

}
