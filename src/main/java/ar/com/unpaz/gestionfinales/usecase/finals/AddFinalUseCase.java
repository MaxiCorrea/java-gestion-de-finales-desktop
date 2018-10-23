package ar.com.unpaz.gestionfinales.usecase.finals;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.usecase.FinalDialogController;
import ar.com.unpaz.gestionfinales.validation.FinalValidator;
import ar.com.unpaz.gestionfinales.validation.Validator;

public class AddFinalUseCase implements FinalDialogController {

  private final Validator<Final> validator;

  public AddFinalUseCase() {
    this(new FinalValidator(), new StudentSelectionController(), new SubjectSelectionController());
  }

  public AddFinalUseCase(Validator<Final> validator, DialogController selectStudent,
      DialogController selectSubject) {
    this.validator = validator;
    AppViewContext.selectStudentDialog.setController(selectStudent);
    AppViewContext.selectSubjectDialog.setController(selectSubject);
  }

  @Override
  public void accept() {
    Final finalObj = AppViewContext.addFinalDialog.getFinal();
    if (validator.isValid(finalObj)) {
      AppRepositoryContext.finalRepository.add(finalObj);
      AppViewContext.finalsView.setFinals(AppRepositoryContext.finalRepository.getAll());
      AppViewContext.addFinalDialog.close();
    } else {
      String errorMessage = validator.getErrorMessage();
      AppViewContext.addFinalDialog.showError(errorMessage);
    }
  }

  @Override
  public void cancel() {
    AppViewContext.addFinalDialog.close();
  }

  @Override
  public void selectStudent() {
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.selectStudentDialog.setStudents(all);
    AppViewContext.selectStudentDialog.show();
  }

  @Override
  public void selectSubject() {
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.selectSubjectDialog.setSubjects(all);
    AppViewContext.selectSubjectDialog.show();
  }

}
