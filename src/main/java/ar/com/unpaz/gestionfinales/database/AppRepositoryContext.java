package ar.com.unpaz.gestionfinales.database;

import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;

public class AppRepositoryContext {
  
  public static EntityRepository<Subject> subjectRepository;
  
  public static EntityRepository<Student> studentRepository;
  
  public static EntityRepository<Final> finalRepository;

}
