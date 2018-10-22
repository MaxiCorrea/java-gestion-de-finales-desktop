package ar.com.unpaz.gestionfinales.usecase.subjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.subjects.AddSubjectDialogFake;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsViewFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class AddSubjectUseCaseTest {

  private AddSubjectDialogFake dialogFake;
  private ValidatorFake<Subject> validatorFake;
  private SubjectRepository subjectRepositoryFake;
  private SubjectsViewFake subjectsViewFake;
  private AddSubjectUseCase usecase;

  @Before
  public void contextConfiguration() {
    dialogFake = new AddSubjectDialogFake();
    AppViewContext.addSubjectDialog = dialogFake;
    validatorFake = new ValidatorFake<>();
    usecase = new AddSubjectUseCase(validatorFake);
    subjectRepositoryFake = new InMemorySubjectRepository();
    AppRepositoryContext.subjectRepository = subjectRepositoryFake;
    subjectsViewFake = new SubjectsViewFake();
    AppViewContext.subjectsView = subjectsViewFake;
  }

  @Test
  public void whenTheOperationOfAddingASubjectIsCanceledTheDialogShouldBeClosed() {
    assertFalse(dialogFake.isClosed());
    usecase.cancel();
    assertTrue(dialogFake.isClosed());
  }

  @Test
  public void whenTheSubjectDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(dialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertEquals(validatorFake.getErrorMessage(), dialogFake.getErrorMessageDisplayed());
  }

  @Test
  public void whenSubjectIsValidItShouldPersistInTheRepositoryUpdateSubjectsViewAndCloseTheDialog() {
    assertFalse(dialogFake.isClosed());
    dialogFake.setSubject(new Subject(0, "Description", Year.FIFTH));
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertEquals(subjectRepositoryFake.getAll().get(0), dialogFake.getSubject());
    assertEquals(subjectsViewFake.getSubjectInRow(0), subjectRepositoryFake.getAll().get(0));
    assertTrue(dialogFake.isClosed());
  }

}
