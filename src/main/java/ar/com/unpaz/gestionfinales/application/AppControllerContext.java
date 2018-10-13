package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.usecase.AppController;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.usecase.finals.FinalController;
import ar.com.unpaz.gestionfinales.usecase.students.StudentController;
import ar.com.unpaz.gestionfinales.usecase.subjects.SubjectController;

public class AppControllerContext {

  public static AppController appController;
  
  public static SubjectController subjectController;

  public static StudentController studentController;
  
  public static FinalController finalController;
  
  public static DialogController dialogController;
  
}