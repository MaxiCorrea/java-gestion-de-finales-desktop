package ar.com.unpaz.gestionfinales.application;

import ar.com.unpaz.gestionfinales.persistence.inmemory.InMemorySubjectRepository;
import ar.com.unpaz.gestionfinales.presentation.view.AppView;

public class Main {

  public static void main(String[] args) {
    Context.subjectRepository = new InMemorySubjectRepository();
    AppView appView = new AppView();
  }
}
