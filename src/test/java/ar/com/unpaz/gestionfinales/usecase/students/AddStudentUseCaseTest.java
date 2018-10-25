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

public class AddStudentUseCaseTest {

  private ValidatorFake<Student> validatorFake;
  private AddStudentUseCase usecase;
  private DialogFake<Student> addStudentDialogFake;
  private ViewFake<Student> studentsViewFake;
  private InMemoryStudentRepository studentRepositoryFake;

  @Before
  public void setup() {
    addStudentDialogFake = new DialogFake<>();
    AppViewContext.addStudentDialog = addStudentDialogFake;
    studentsViewFake = new ViewFake<>();
    AppViewContext.studentsView = studentsViewFake;
    studentRepositoryFake = new InMemoryStudentRepository();
    AppRepositoryContext.studentRepository = studentRepositoryFake;
    validatorFake = new ValidatorFake<>();
    usecase = new AddStudentUseCase(validatorFake);
  }

  @Test
  public void whenTheOperationOfAddingAStudentIsCanceledTheDialogShouldBeClosed() {
    assertFalse(addStudentDialogFake.isClosed());
    usecase.cancel();
    assertTrue(addStudentDialogFake.isClosed());
    assertTrue(studentRepositoryFake.noInteractions());
  }

  @Test
  public void whenTheStudentDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(addStudentDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(studentRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), addStudentDialogFake.getErrorMessage());
  }
  
  @Test
  public void whenStudentIsValidItShouldPersistUpdateStudentsViewAndCloseTheDialog() {
    assertFalse(addStudentDialogFake.isClosed());
    Student maxi = new Student("1233","Maxi", "Correa", "jmaxicorrea@gmail.com");
    addStudentDialogFake.set(maxi);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(studentRepositoryFake.getAll().isEmpty());
    assertTrue(studentsViewFake.getAll().contains(maxi));
    assertTrue(addStudentDialogFake.isClosed());
  }
  
}
