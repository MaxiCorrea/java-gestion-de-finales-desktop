package ar.com.unpaz.gestionfinales.usecase;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class AppControllerContext {

  public static AppController appController;
      
  public static UseCases<Final> finalUseCases;
  
  public static UseCases<Subject> subjectUseCases;
  
  public static UseCases<Student> studentUseCases;
    
  public static DialogController dialogController;
  
}
