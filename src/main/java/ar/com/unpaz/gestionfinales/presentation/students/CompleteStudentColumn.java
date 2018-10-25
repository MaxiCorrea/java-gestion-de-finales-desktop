package ar.com.unpaz.gestionfinales.presentation.students;

import ar.com.unpaz.gestionfinales.domain.Student;

public enum CompleteStudentColumn {

  DNI("Dni") {
    @Override
    public Object valueIn(Student student) {
      return student.getDni();
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

  private CompleteStudentColumn(String name) {
    this.name = name;
  }

  public static CompleteStudentColumn at(int offset) {
    return values()[offset];
  }

}
