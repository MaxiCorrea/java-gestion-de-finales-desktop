package ar.com.unpaz.gestionfinales.domain;

public class Student extends Entity {

  public final static Student EMPTY = new Student(0, "", "", "");

  private final String name;
  private final String surname;
  private final String email;

  public Student(int dni, String name, String surname, String email) {
    super(dni);
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getEmail() {
    return email;
  }

}
