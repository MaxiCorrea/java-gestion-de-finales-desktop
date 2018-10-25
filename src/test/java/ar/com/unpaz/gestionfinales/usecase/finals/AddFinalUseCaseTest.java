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

public class AddFinalUseCaseTest {
  
  private DialogFake<Final> addFinalDialogFake;
  private ViewFake<Final> finalViewFake;
  private InMemoryFinalRepository finalRepositoryFake;
  private ValidatorFake<Final> validatorFake;
  private AddFinalUseCase usecase;
  
  @Before
  public void setup() {
    addFinalDialogFake = new DialogFake<>();
    AppViewContext.addFinalDialog = addFinalDialogFake;
    finalViewFake = new ViewFake<>();
    AppViewContext.finalsView = finalViewFake;
    finalRepositoryFake = new InMemoryFinalRepository();
    AppRepositoryContext.finalRepository = finalRepositoryFake;
    validatorFake = new ValidatorFake<>();
    usecase = new AddFinalUseCase(validatorFake);
  }
  
  @Test
  public void whenTheOperationOfAddingAFinalIsCanceledTheDialogShouldBeClosed() {
    assertFalse(addFinalDialogFake.isClosed());
    usecase.cancel();
    assertTrue(addFinalDialogFake.isClosed());
    assertTrue(finalRepositoryFake.noInteractions());
  }
  
  @Test
  public void whenTheFinalDataIsInvalidAErrorMessageMustBeDisplayedInTheDialog() {
    assertFalse(addFinalDialogFake.isClosed());
    validatorFake.isValidWillReturnFalse();
    validatorFake.getErrorMessageReturn("Error");
    usecase.accept();
    assertTrue(finalRepositoryFake.noInteractions());
    assertEquals(validatorFake.getErrorMessage(), addFinalDialogFake.getErrorMessage());
  }
  
  @Test
  public void whenFinalIsValidItShouldPersistUpdateStudentsViewAndCloseTheDialog() {
    assertFalse(addFinalDialogFake.isClosed());
    Subject java = new Subject(0,"Java Programming", Year.FIRST);
    Student maxi = new Student("36160077","Maxi","Correa","jmaxicorrea@gmail.com");
    Final finalProgramming = new Final(0,java,maxi,now() , TEN);
    addFinalDialogFake.set(finalProgramming);
    validatorFake.isValidWillReturnTrue();
    usecase.accept();
    assertFalse(finalRepositoryFake.getAll().isEmpty());
    assertTrue(finalViewFake.getAll().contains(finalProgramming));
    assertTrue(addFinalDialogFake.isClosed());
  }
  
}
