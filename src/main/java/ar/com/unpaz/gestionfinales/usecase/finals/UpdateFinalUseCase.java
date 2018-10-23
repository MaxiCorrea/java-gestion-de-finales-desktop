package ar.com.unpaz.gestionfinales.usecase.finals;

import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.usecase.FinalDialogController;
import ar.com.unpaz.gestionfinales.validation.FinalValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class UpdateFinalUseCase implements FinalDialogController {

  private final Validator<Final> validator;

  public UpdateFinalUseCase() {
    validator = new FinalValidator();
  }

  public UpdateFinalUseCase(Validator<Final> validator) {
    this.validator = validator;
  }

  @Override
  public void accept() {
    Final finalObject = AppViewContext.updFinalDialog.getFinal();
    if (validator.isValid(finalObject)) {
      AppRepositoryContext.finalRepository.update(finalObject);
      AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
      AppViewContext.updFinalDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.updFinalDialog.showError(errorMessage);
    }
  }

  @Override
  public void selectStudent() {
    AppViewContext.selectStudentDialog.setStudents(AppRepositoryContext.studentRepository.getAll());
    AppViewContext.selectStudentDialog.setController(new DialogController() {
      @Override
      public void cancel() {
        AppViewContext.updFinalDialog.close();
      }

      @Override
      public void accept() {
        if (AppViewContext.selectStudentDialog.getSelectedRow() != -1) {
          int row = AppViewContext.selectStudentDialog.getSelectedRow();
          Student student = AppViewContext.selectStudentDialog.getStudentInRow(row);
          AppViewContext.updFinalDialog.setStudent(student);
          AppViewContext.selectStudentDialog.close();
        }
      }
    });
    AppViewContext.selectStudentDialog.show();
  }

  @Override
  public void selectSubject() {
    AppViewContext.selectSubjectDialog.setSubjects(AppRepositoryContext.subjectRepository.getAll());
    AppViewContext.selectSubjectDialog.setController(new DialogController() {

      @Override
      public void accept() {
        if (AppViewContext.selectSubjectDialog.getSelectedRow() != -1) {
          int row = AppViewContext.selectSubjectDialog.getSelectedRow();
          Subject subject = AppViewContext.selectSubjectDialog.getSubjectInRow(row);
          AppViewContext.updFinalDialog.setSubject(subject);
          AppViewContext.selectSubjectDialog.close();
        }
      }

      @Override
      public void cancel() {
        AppViewContext.selectSubjectDialog.close();
      }

    });
    AppViewContext.selectSubjectDialog.show();
  }

  @Override
  public void cancel() {
    AppViewContext.updFinalDialog.close();
  }

}
