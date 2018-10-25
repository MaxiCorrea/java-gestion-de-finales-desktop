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
import ar.com.unpaz.gestionfinales.presentation.DialogFake;
import ar.com.unpaz.gestionfinales.presentation.ViewFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class AddSubjectUseCaseTest {

  private DialogFake<Subject> addSubjectDialogFake;
  private ValidatorFake<Subject> validatorFake;
  private InMemorySubjectRepository subjectRepositoryFake;
  private ViewFake<Subject> subjectsViewFake;
  private AddSubjectUseCase usecase;
  
  @Before
  public void setup() {
    addSubjectDialogFake = new DialogFake<>();
    AppViewContext.addSubjectDialog = addSubjectDialogFake;
    subjectRepositoryFake = new InMemorySubjectRepository();
    AppRepositoryContext.subjectRepository = subjectRepositoryFake;
    subjectsViewFake = new ViewFake<>();
    AppViewContext.subjectsView = subjectsViewFake;
    validatorFake = new ValidatorFake<>();
    usecase = new AddSubjectUseCase(validatorFake);
  }

  @Test
  public void whenTheOperationOfAddingASubjectIsCanceledTheDialogShouldBeClosed() {
    assertFalse(addSubjectDialogFake.isClosed());
    usecase.cancel();
    assertTrue(addSubjectDialogFake.isClosed());
    assertTrue(subjectRepositoryFake.noInteractions());
  }

  @Test
  public void whenTheSubjectDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(addSubjectDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(subjectRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), addSubjectDialogFake.getErrorMessage());
  }

  @Test
  public void whenSubjectIsValidItShouldPersistUpdateSubjectsViewAndCloseTheDialog() {
    assertFalse(addSubjectDialogFake.isClosed());
    Subject dataStructures = new Subject(0,"Data-Structures", Year.FOURTH);
    addSubjectDialogFake.set(dataStructures);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(subjectRepositoryFake.getAll().isEmpty());
    assertTrue(subjectsViewFake.getAll().contains(dataStructures));
    assertTrue(addSubjectDialogFake.isClosed());
  }

}
