package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;

public class Main {

  public static void main(String[] args) {
    Context.subjectRepository = new InMemorySubjectRepository();
    
  }
}
