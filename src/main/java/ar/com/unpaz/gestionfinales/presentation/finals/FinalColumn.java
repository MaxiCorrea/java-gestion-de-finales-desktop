package ar.com.unpaz.gestionfinales.presentation.finals;

import ar.com.unpaz.gestionfinales.domain.Final;

public enum FinalColumn {

  ID("Id") {
    @Override
    public Object valueIn(Final finalObj) {
      return finalObj.getId();
    }
  },

  SUBJECT("Materia") {
    @Override
    public Object valueIn(Final finalObj) {
      return finalObj.getSubject().getDescription();
    }
  },

  STUDENT("Alumno") {
    @Override
    public Object valueIn(Final finalObj) {
      return finalObj.getStudent().getName() + " " + 
             finalObj.getStudent().getSurname();
    }
  },

  DATE("Fecha") {
    @Override
    public Object valueIn(Final finalObj) {
      return finalObj.getDate();
    }
  },

  NOTE("Nota") {
    @Override
    public Object valueIn(Final finalObj) {
      return finalObj.getNote().number;
    }
  };

  abstract public Object valueIn(Final finalObj);

  public final String name;

  private FinalColumn(String name) {
    this.name = name;
  }

  public static FinalColumn at(int offset) {
    return values()[offset];
  }

}
