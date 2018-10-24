package ar.com.unpaz.gestionfinales.usecase;

import java.util.List;
import ar.com.unpaz.gestionfinales.database.AppRepositoryContext;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.AppViewContext;

public class AppControllerImpl implements AppController {

  @Override
  public void selectedSubjects() {
    List<Subject> all = AppRepositoryContext.subjectRepository.getAll();
    AppViewContext.subjectsView.set(all);
    AppViewContext.subjectsView.show();
  }

  @Override
  public void selectedStudents() {
    List<Student> all = AppRepositoryContext.studentRepository.getAll();
    AppViewContext.studentsView.set(all);
    AppViewContext.studentsView.show();
  }

  @Override
  public void selectedFinals() {
    List<Final> all = AppRepositoryContext.finalRepository.getAll();
    AppViewContext.finalsView.set(all);
    AppViewContext.finalsView.show();
  }

  @Override
  public void selectedAbout() {
    AppViewContext.aboutDialog.show();
  }

  @Override
  public void closeApp() {
    AppViewContext.appView.close();
  }

  @Override
  public void startApp() {
    AppViewContext.appView.show();
  }

}
