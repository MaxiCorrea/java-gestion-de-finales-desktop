package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;

public enum StudentColumn {

  DNI("Dni") {
    @Override
    public Object valueIn(Student student) {
      return student.getId();
    }
  },

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
  },

  EMAIL("Email") {
    @Override
    public Object valueIn(Student student) {
      return student.getEmail();
    }
  };

  abstract public Object valueIn(Student student);

  public final String name;

  private StudentColumn(String name) {
    this.name = name;
  }

  public static StudentColumn at(int offset) {
    return values()[offset];
  }

}
