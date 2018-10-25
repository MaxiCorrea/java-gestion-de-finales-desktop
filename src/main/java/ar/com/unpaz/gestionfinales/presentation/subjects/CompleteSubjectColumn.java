package ar.com.unpaz.gestionfinales.presentation.subjects;

import ar.com.unpaz.gestionfinales.domain.Subject;

public enum CompleteSubjectColumn {

  ID("Id") {
    @Override
    public Object valueIn(Subject subject) {
      return subject.getId();
    }
  } ,
  
  DESCRIPTION("Descripción") {
    @Override
    public Object valueIn(Subject subject) {
      return subject.getDescription();
    }
  } ,
  
  YEAR("Año") {
    @Override
    public Object valueIn(Subject subject) {
      return subject.getYear();
    }
  };
  
  abstract public Object valueIn(Subject subject);

  public final String name;

  private CompleteSubjectColumn(String name) {
    this.name = name;
  }

  public static CompleteSubjectColumn at(int offset) {
    return values()[offset];
  }
  
}
