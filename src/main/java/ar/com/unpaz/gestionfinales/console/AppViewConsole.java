package ar.com.unpaz.gestionfinales.console;

import java.util.Scanner;
import ar.com.unpaz.gestionfinales.presentation.AppView;
import ar.com.unpaz.gestionfinales.usecase.AppControllerContext;

public class AppViewConsole implements AppView {

  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  private static final String APP_TITLE = "Sistema de gestion de finales";
  private static final String MENU_SUBJECT_TITLE = "1 ) Materias ";
  private static final String MENU_STUDENTS_TITLE = "2 ) Alumnos ";
  private static final String MENU_FINALS_TITLE = "3 ) Finales ";
  private static final String MENU_ABOUT_TITLE = "4 ) Acerca de ";
  private static final String MENU_EXIT_TITLE = "5 ) Salir ";

  private boolean running;

  public AppViewConsole() {
    running = false;
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
    println(APP_TITLE);
  }

  private void showMenu() {
    println(MENU_SUBJECT_TITLE);
    println(MENU_STUDENTS_TITLE);
    println(MENU_FINALS_TITLE);
    println(MENU_ABOUT_TITLE);
    println(MENU_EXIT_TITLE);
  }

  private void controlOption() {
    int selectedOption = scanner.nextInt();
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

  private static void println(Object obj) {
    System.out.println(obj);
  }

  @Override
  public void close() {
    running = false;
    scanner.close();
  }

}
