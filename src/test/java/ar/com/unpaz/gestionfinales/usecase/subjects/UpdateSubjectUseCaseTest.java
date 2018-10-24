package ar.com.unpaz.gestionfinales.usecase.subjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsViewFake;
import ar.com.unpaz.gestionfinales.presentation.subjects.UpdateSubjectDialogFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class UpdateSubjectUseCaseTest {

  private ValidatorFake<Subject> validatorFake;
  private InMemorySubjectRepository subjectRepositoryFake;
  private UpdateSubjectDialogFake updateSubjectDialogFake;
  private SubjectsViewFake subjectsViewFake;
  private UpdateSubjectUseCase usecase;
  
  @Before
  public void setup() {
    updateSubjectDialogFake = new UpdateSubjectDialogFake();
    AppViewContext.updSubjectDialog = updateSubjectDialogFake;
    subjectsViewFake = new SubjectsViewFake();
    AppViewContext.subjectsView = subjectsViewFake;
    subjectRepositoryFake = new InMemorySubjectRepository();
    AppRepositoryContext.subjectRepository = subjectRepositoryFake;
    validatorFake = new ValidatorFake<>();
    usecase = new UpdateSubjectUseCase(validatorFake);
  }
  
  @Test
  public void whenTheOperationOfUpdateASubjectIsCanceledTheDialogShouldBeClosed() {
    assertFalse(updateSubjectDialogFake.isClosed());
    usecase.cancel();
    assertTrue(updateSubjectDialogFake.isClosed());
    assertTrue(subjectRepositoryFake.noInteractions());
  }

  @Test
  public void whenTheSubjectDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(updateSubjectDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(subjectRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), updateSubjectDialogFake.getErrorDisplayed());
  }
  
  @Test
  public void whenSubjectIsValidItShouldPersistUpdateSubjectsViewAndCloseTheDialog() {
    assertFalse(updateSubjectDialogFake.isClosed());
    Subject dataStructures = new Subject(0,"Data-Structures", Year.FOURTH);
    updateSubjectDialogFake.set(dataStructures);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(subjectRepositoryFake.getAll().isEmpty());
    assertTrue(subjectsViewFake.getSubjects().contains(dataStructures));
    assertTrue(updateSubjectDialogFake.isClosed());
  }
  
}
