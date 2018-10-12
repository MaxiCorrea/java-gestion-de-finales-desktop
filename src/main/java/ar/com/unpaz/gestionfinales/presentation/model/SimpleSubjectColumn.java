package ar.com.unpaz.gestionfinales.presentation.model;

import ar.com.unpaz.gestionfinales.domain.Subject;

public enum SimpleSubjectColumn {

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

  private SimpleSubjectColumn(String name) {
    this.name = name;
  }
  
  public static SimpleSubjectColumn at(int offset) {
    return values()[offset];
  }
  
}
