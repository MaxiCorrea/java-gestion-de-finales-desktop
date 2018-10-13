package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.database.FinalRepository;
import ar.com.unpaz.gestionfinales.database.StudentRepository;
import ar.com.unpaz.gestionfinales.database.SubjectRepository;

public class AppRepositoryContext {

  public static SubjectRepository subjectRepository;
  
  public static StudentRepository studentRepository;
  
  public static FinalRepository finalRepository;
  
}
