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
import ar.com.unpaz.gestionfinales.presentation.subjects.AddStudentDialogFake;
import ar.com.unpaz.gestionfinales.presentation.subjects.StudentViewFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class AddStudentUseCaseTest {

  private ValidatorFake<Student> validatorFake;
  private AddStudentUseCase usecase;
  private AddStudentDialogFake addStudentDialogFake;
  private StudentViewFake studentsViewFake;
  private InMemoryStudentRepository studentRepositoryFake;

  @Before
  public void setup() {
    validatorFake = new ValidatorFake<>();
    usecase = new AddStudentUseCase(validatorFake);
    addStudentDialogFake = new AddStudentDialogFake();
    AppViewContext.addStudentDialog = addStudentDialogFake;
    studentsViewFake = new StudentViewFake();
    AppViewContext.studentsView = studentsViewFake;
    studentRepositoryFake = new InMemoryStudentRepository();
    AppRepositoryContext.studentRepository = studentRepositoryFake;
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
    assertEquals(validatorFake.getErrorMessage(), addStudentDialogFake.getErrorMessageDisplayed());
  }
  
  @Test
  public void whenStudentIsValidItShouldPersistUpdateStudentsViewAndCloseTheDialog() {
    assertFalse(addStudentDialogFake.isClosed());
    Student maxi = new Student("1233","Maxi", "Correa", "jmaxicorrea@gmail.com");
    addStudentDialogFake.setStudent(maxi);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(studentRepositoryFake.getAll().isEmpty());
    assertTrue(studentsViewFake.getStudents().contains(maxi));
    assertTrue(addStudentDialogFake.isClosed());
  }
  
}
