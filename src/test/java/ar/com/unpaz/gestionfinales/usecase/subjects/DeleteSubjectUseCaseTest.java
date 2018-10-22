package ar.com.unpaz.gestionfinales.usecase.subjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.subjects.DeleteSubjectDialogFake;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsViewFake;

public class DeleteSubjectUseCaseTest {

  private DeleteSubjectDialogFake deleteSubjectDialogFake;
  private InMemorySubjectRepository subjectRepositoryFake;
  private SubjectsViewFake subjectsViewFake;
  private DeleteSubjectUseCase usecase;

  @Before
  public void contextConfiguration() {
    usecase = new DeleteSubjectUseCase();
    deleteSubjectDialogFake = new DeleteSubjectDialogFake();
    AppViewContext.delSubjectDialog = deleteSubjectDialogFake;
    subjectRepositoryFake = new InMemorySubjectRepository();
    AppRepositoryContext.subjectRepository = subjectRepositoryFake;
    subjectsViewFake = new SubjectsViewFake();
    AppViewContext.subjectsView = subjectsViewFake;
  }

  @Test
  public void whenTheOperationOfDeleteASubjectIsCanceledTheDialogShouldBeClosed() {
    assertFalse(deleteSubjectDialogFake.isClosed());
    usecase.cancel();
    assertTrue(subjectRepositoryFake.noInteractions());
    assertTrue(deleteSubjectDialogFake.isClosed());
  }

  @Test
  public void whenTheDeletionOfASubjectIsAcceptedItMustBeRemovedFromTheRepositoryTheViewUpdatedAndTheDialogClosed() {
    assertFalse(deleteSubjectDialogFake.isClosed());
    Subject dataStructures = new Subject(0, "Data-Structures", Year.FOURTH);
    subjectRepositoryFake.add(dataStructures);
    deleteSubjectDialogFake.setSubject(dataStructures);
    usecase.accept();
    assertFalse(subjectRepositoryFake.getAll().contains(dataStructures));
    assertFalse(subjectsViewFake.getSubjects().contains(dataStructures));
    assertTrue(deleteSubjectDialogFake.isClosed());
  }

}
