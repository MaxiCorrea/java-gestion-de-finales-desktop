package ar.com.unpaz.gestionfinales.usecase.students;

import static org.junit.Assert.assertEquals;
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
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class UpdateStudentUseCaseTest {

  private ViewFake<Student> studentsViewFake;
  private DialogFake<Student> updateStudentDialogFake;
  private InMemoryStudentRepository studentRepositoryFake;
  private ValidatorFake<Student> validatorFake;
  private UpdateStudentUseCase usecase;

  @Before
  public void setup() {
    studentsViewFake = new ViewFake<>();
    AppViewContext.studentsView = studentsViewFake;
    updateStudentDialogFake = new DialogFake<>();
    AppViewContext.updStudentDialog = updateStudentDialogFake;
    studentRepositoryFake = new InMemoryStudentRepository();
    AppRepositoryContext.studentRepository = studentRepositoryFake;
    validatorFake = new ValidatorFake<>();
    usecase = new UpdateStudentUseCase(validatorFake);
  }

  @Test
  public void whenTheOperationOfUpdateAStudentIsCanceledTheDialogShouldBeClosed() {
    assertFalse(updateStudentDialogFake.isClosed());
    usecase.cancel();
    assertTrue(updateStudentDialogFake.isClosed());
    assertTrue(studentRepositoryFake.noInteractions());
  }
  
  @Test
  public void whenTheStudentDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(updateStudentDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(studentRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), updateStudentDialogFake.getErrorMessage());
  }
  
  @Test
  public void whenStudentIsValidItShouldPersistUpdateStudentsViewAndCloseTheDialog() {
    assertFalse(updateStudentDialogFake.isClosed());
    Student maxi = new Student("1233","Maxi", "Correa", "jmaxicorrea@gmail.com");
    updateStudentDialogFake.set(maxi);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(studentRepositoryFake.getAll().isEmpty());
    assertTrue(studentsViewFake.getAll().contains(maxi));
    assertTrue(updateStudentDialogFake.isClosed());
  }
  
}
