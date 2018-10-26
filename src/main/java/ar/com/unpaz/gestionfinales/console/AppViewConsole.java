package ar.com.unpaz.gestionfinales.console;

import ar.com.unpaz.gestionfinales.presentation.AppView;
import ar.com.unpaz.gestionfinales.usecase.AppControllerContext;

public class AppViewConsole implements AppView {

  private static final String APP_TITLE = "Sistema de gestion de finales";
  private static final String SUBJECT_TITLE = "1 ) Materias ";
  private static final String STUDENTS_TITLE = "2 ) Alumnos ";
  private static final String FINALS_TITLE = "3 ) Finales ";
  private static final String ABOUT_TITLE = "4 ) Acerca de ";
  private static final String EXIT_TITLE = "5 ) Salir ";

  private ConsoleWriter writer;
  private ConsoleReader reader;
  private boolean running;

  public AppViewConsole() {
    running = false;
    writer = new ConsoleWriter();
    reader = new ConsoleReader();
  }

  public AppViewConsole(ConsoleWriter writer ,
                        ConsoleReader reader ) {
    this.writer = writer;
    this.reader = reader;
  }
  
  @Override
  public void show() {
    running = true;
    showTitleApp();
    startLoop();
  }

  private void startLoop() {
    while (running) {
      showMenu();
      controlOption();
    }
  }

  private void showTitleApp() {
    writer.println(APP_TITLE);
  }

  private void showMenu() {
    writer.println(SUBJECT_TITLE);
    writer.println(STUDENTS_TITLE);
    writer.println(FINALS_TITLE);
    writer.println(ABOUT_TITLE);
    writer.println(EXIT_TITLE);
  }

  private void controlOption() {
    int selectedOption = reader.readInteger();
    if (selectedOption == 1) {
      AppControllerContext.appController.selectedSubjects();
    }
    if (selectedOption == 2) {
      AppControllerContext.appController.selectedStudents();
    }
    if (selectedOption == 3) {
      AppControllerContext.appController.selectedFinals();
    }
    if (selectedOption == 4) {
      AppControllerContext.appController.selectedAbout();
    }
    if (selectedOption == 5) {
      this.close();
    }
  }

  @Override
  public void close() {
    running = false;
    reader.close();
  }

  @Override
  public void showError(String message) {
    
  }

  @Override
  public void showMessage(String string) {
    // TODO Auto-generated method stub
    
  }

}
