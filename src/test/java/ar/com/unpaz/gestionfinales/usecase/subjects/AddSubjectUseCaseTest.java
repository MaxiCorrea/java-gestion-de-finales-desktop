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
import ar.com.unpaz.gestionfinales.presentation.subjects.AddSubjectDialogFake;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsViewFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class AddSubjectUseCaseTest {

  private AddSubjectDialogFake addSubjectDialogFake;
  private ValidatorFake<Subject> validatorFake;
  private InMemorySubjectRepository subjectRepositoryFake;
  private SubjectsViewFake subjectsViewFake;
  private AddSubjectUseCase usecase;

  @Before
  public void setup() {
    validatorFake = new ValidatorFake<>();
    usecase = new AddSubjectUseCase(validatorFake);
  }

  @Before
  public void contextConfiguration() {
    addSubjectDialogFake = new AddSubjectDialogFake();
    AppViewContext.addSubjectDialog = addSubjectDialogFake;
    subjectRepositoryFake = new InMemorySubjectRepository();
    AppRepositoryContext.subjectRepository = subjectRepositoryFake;
    subjectsViewFake = new SubjectsViewFake();
    AppViewContext.subjectsView = subjectsViewFake;
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
    assertEquals(validatorFake.getErrorMessage(), addSubjectDialogFake.getErrorMessageDisplayed());
  }

  @Test
  public void whenSubjectIsValidItShouldPersistUpdateSubjectsViewAndCloseTheDialog() {
    assertFalse(addSubjectDialogFake.isClosed());
    Subject dataStructures = new Subject(0, "Data-Structures", Year.FOURTH);
    addSubjectDialogFake.setSubject(dataStructures);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(subjectRepositoryFake.getAll().isEmpty());
    assertTrue(subjectsViewFake.getSubjects().contains(dataStructures));
    assertTrue(addSubjectDialogFake.isClosed());
  }

}
