package ar.com.unpaz.gestionfinales.usecase;

import ar.com.unpaz.gestionfinales.usecase.finals.FinalUseCases;
import ar.com.unpaz.gestionfinales.usecase.students.StudentUseCases;
import ar.com.unpaz.gestionfinales.usecase.subjects.SubjectUseCases;

public class AppControllerContext {

  public static AppController appController;
  
  public static SubjectUseCases subjectController;

  public static StudentUseCases studentController;
  
  public static FinalUseCases finalController;
  
  public static DialogController dialogController;
  
}
