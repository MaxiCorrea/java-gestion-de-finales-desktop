package ar.com.unpaz.gestionfinales.usecase.finals;

import static ar.com.unpaz.gestionfinales.domain.Qualification.TEN;
import static java.time.LocalDate.now;
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

public class DeleteFinalUseCaseTest {

  private DialogFake<Final> delFinalDialogFake;
  private ViewFake<Final> finalViewFake;
  private InMemoryFinalRepository finalRepositoryFake;
  private DeleteFinalUseCase usecase;
  
  @Before
  public void setup() {
    finalViewFake = new ViewFake<>();
    AppViewContext.finalsView = finalViewFake;
    delFinalDialogFake = new DialogFake<>();
    AppViewContext.delFinalDialog = delFinalDialogFake;
    finalRepositoryFake = new InMemoryFinalRepository();
    AppRepositoryContext.finalRepository = finalRepositoryFake;
    usecase = new DeleteFinalUseCase();
  }
  
  @Test
  public void whenTheOperationOfDeleteAFinalIsCanceledTheDialogShouldBeClosed() {
    assertFalse(delFinalDialogFake.isClosed());
    usecase.cancel();
    assertTrue(finalRepositoryFake.noInteractions());
    assertTrue(delFinalDialogFake.isClosed());
  }
  
  @Test
  public void whenTheDeletionOfAFinalIsAcceptedItMustBeRemovedFromTheRepositoryTheViewUpdatedAndTheDialogClosed() {
    assertFalse(delFinalDialogFake.isClosed());
    Subject java = new Subject(0,"Java Programming", Year.FIRST);
    Student maxi = new Student("36160077","Maxi","Correa","jmaxicorrea@gmail.com");
    Final finalProgramming = new Final(0,java,maxi,now() , TEN);
    finalRepositoryFake.add(finalProgramming);
    delFinalDialogFake.set(finalProgramming);
    usecase.accept();
    assertFalse(finalRepositoryFake.getAll().contains(maxi));
    assertFalse(finalViewFake.getAll().contains(maxi));
    assertTrue(delFinalDialogFake.isClosed());
  }

}
