package ar.com.unpaz.gestionfinales.presentation.model;

import ar.com.unpaz.gestionfinales.domain.Student;

public enum SimpleStudentColumn {

  NAME("Nombre") {
    @Override
    public Object valueIn(Student student) {
      return student.getName();
    }
  },

  SURNAME("Apellido") {
    @Override
    public Object valueIn(Student student) {
      return student.getSurname();
    }
  };

  abstract public Object valueIn(Student student);

  public final String name;

  private SimpleStudentColumn(String name) {
    this.name = name;
  }

  public static SimpleStudentColumn at(int offset) {
    return values()[offset];
  }

}
