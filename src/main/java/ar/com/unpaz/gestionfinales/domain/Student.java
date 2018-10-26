package ar.com.unpaz.gestionfinales.domain;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Student extends Entity<Student> {

  public final static Student EMPTY = new Student("", "", "", "");

  private final String dni;
  private final String name;
  private final String surname;
  private final String email;

  public Student(int dni, String name, String surname, String email) {
    super(dni);
    this.dni = valueOf(requireNonNull(dni));
    this.name = requireNonNull(name);
    this.surname = requireNonNull(surname);
    this.email = requireNonNull(email);
  }

  public Student(String dni, String name, String surname, String email) {
    this.dni = requireNonNull(dni);
    this.name = requireNonNull(name);
    this.surname = requireNonNull(surname);
    this.email = requireNonNull(email);
  }

  public String getDni() {
    return dni;
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

  public boolean hasEmptyName() {
    return name.isEmpty();
  }
  
  public boolean hasEmptySurname() {
    return surname.isEmpty();
  }
  
  public boolean hasEmptyEmail() {
    return email.isEmpty();
  }
  
  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }

  public String getFullName() {
    return format("%s %s", getName(), getSurname());
  }
 
  @Override
  public String toString() {
    return "Student [dni=" + dni + ", name=" + name + ", surname=" + surname + ", email=" + email
        + "]";
  }
  
}
