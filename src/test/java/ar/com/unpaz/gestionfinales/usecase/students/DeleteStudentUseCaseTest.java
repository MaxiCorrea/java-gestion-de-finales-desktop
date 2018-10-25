package ar.com.unpaz.gestionfinales.usecase.students;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.inmemory.InMemoryStudentRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.DialogFake;
import ar.com.unpaz.gestionfinales.presentation.ViewFake;

public class DeleteStudentUseCaseTest {

  private DeleteStudentUseCase usecase;
  private ViewFake<Student> studentsViewFake;
  private DialogFake<Student> deleteStudentDialogFake;
  private InMemoryStudentRepository studentRepositoryFake;

  @Before
  public void setup() {
    studentsViewFake = new ViewFake<>();
    AppViewContext.studentsView = studentsViewFake;
    deleteStudentDialogFake = new DialogFake<>();
    AppViewContext.delStudentDialog = deleteStudentDialogFake;
    studentRepositoryFake = new InMemoryStudentRepository();
    AppRepositoryContext.studentRepository = studentRepositoryFake;
    usecase = new DeleteStudentUseCase();
  }

  @Test
  public void whenTheOperationOfDeleteAStudentIsCanceledTheDialogShouldBeClosed() {
    assertFalse(deleteStudentDialogFake.isClosed());
    usecase.cancel();
    assertTrue(studentRepositoryFake.noInteractions());
    assertTrue(deleteStudentDialogFake.isClosed());
  }

  @Test
  public void whenTheDeletionOfAStudentIsAcceptedItMustBeRemovedFromTheRepositoryTheViewUpdatedAndTheDialogClosed() {
    assertFalse(deleteStudentDialogFake.isClosed());
    Student maxi = new Student("1233","Maxi", "Correa", "jmaxicorrea@gmail.com");
    studentRepositoryFake.add(maxi);
    deleteStudentDialogFake.set(maxi);
    usecase.accept();
    assertFalse(studentRepositoryFake.getAll().contains(maxi));
    assertFalse(studentsViewFake.getAll().contains(maxi));
    assertTrue(deleteStudentDialogFake.isClosed());
  }
  
}
