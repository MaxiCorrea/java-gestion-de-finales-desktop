package ar.com.unpaz.gestionfinales.usecase;

import ar.com.unpaz.gestionfinales.database.FinalRepository;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.AppView;
import ar.com.unpaz.gestionfinales.presentation.finals.FinalsView;
import ar.com.unpaz.gestionfinales.presentation.students.StudentsView;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsView;

public class AppControllerImpl implements AppController {

  private final AppView appView;
  private final SubjectsView subjectsView;
  private final SubjectRepository subjectRepository;
  private final StudentsView studentsView;
  private final StudentRepository studentRepository;
  private final FinalsView finalsView;
  private final FinalRepository finalRepository;

  public AppControllerImpl(AppView appView, SubjectsView subjectsView,
      SubjectRepository subjectRepository, StudentsView studentsView,
      StudentRepository studentRepository, FinalsView finalsView,
      FinalRepository finalsRepository) {

    this.appView = appView;
    this.subjectsView = subjectsView;
    this.subjectRepository = subjectRepository;
    this.studentsView = studentsView;
    this.studentRepository = studentRepository;
    this.finalsView = finalsView;
    this.finalRepository = finalsRepository;
  }

  @Override
  public void selectedSubjects() {
    subjectsView.setSubjects(subjectRepository.getAll());
    subjectsView.show();
  }

  @Override
  public void selectedStudents() {
    studentsView.setStudents(studentRepository.getAll());
    studentsView.show();
  }

  @Override
  public void selectedFinals() {
    finalsView.setFinals(finalRepository.getAll());
    finalsView.show();
  }

  @Override
  public void selectedAbout() {

  }

  @Override
  public void closeApp() {
    appView.close();
  }

  @Override
  public void startApp() {
    appView.show();
  }

}
