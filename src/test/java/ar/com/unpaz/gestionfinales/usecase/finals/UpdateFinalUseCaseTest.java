package ar.com.unpaz.gestionfinales.usecase.finals;

import static ar.com.unpaz.gestionfinales.domain.Qualification.TEN;
import static java.time.LocalDate.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.inmemory.InMemoryFinalRepository;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;
import ar.com.unpaz.gestionfinales.presentation.DialogFake;
import ar.com.unpaz.gestionfinales.presentation.ViewFake;
import ar.com.unpaz.gestionfinales.validation.ValidatorFake;

public class UpdateFinalUseCaseTest {

  private ViewFake<Final> finalsViewFake;
  private DialogFake<Final> updateFinalDialogFake;
  private InMemoryFinalRepository finalRepositoryFake;
  private ValidatorFake<Final> validatorFake;
  private UpdateFinalUseCase usecase;
  
  @Before
  public void test() {
    finalsViewFake = new ViewFake<>();
    AppViewContext.finalsView = finalsViewFake;
    updateFinalDialogFake = new DialogFake<>();
    AppViewContext.updFinalDialog = updateFinalDialogFake;
    finalRepositoryFake = new InMemoryFinalRepository();
    AppRepositoryContext.finalRepository = finalRepositoryFake;
    validatorFake = new ValidatorFake<>();
    usecase = new UpdateFinalUseCase(validatorFake);
  }

  @Test
  public void whenTheOperationOfUpdateAStudentIsCanceledTheDialogShouldBeClosed() {
    assertFalse(updateFinalDialogFake.isClosed());
    usecase.cancel();
    assertTrue(updateFinalDialogFake.isClosed());
    assertTrue(finalRepositoryFake.noInteractions());
  }
  
  @Test
  public void whenTheStudentDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(updateFinalDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(finalRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), updateFinalDialogFake.getErrorMessage());
  }
  
  @Test
  public void whenFinalIsValidItShouldPersistUpdateStudentsViewAndCloseTheDialog() {
    assertFalse(updateFinalDialogFake.isClosed());
    Subject java = new Subject(0,"Java Programming", Year.FIRST);
    Student maxi = new Student("36160077","Maxi","Correa","jmaxicorrea@gmail.com");
    Final finalProgramming = new Final(0,java,maxi,now() , TEN);
    updateFinalDialogFake.set(finalProgramming);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(finalRepositoryFake.getAll().isEmpty());
    assertTrue(finalsViewFake.getAll().contains(finalProgramming));
    assertTrue(updateFinalDialogFake.isClosed());
  }
  
}
