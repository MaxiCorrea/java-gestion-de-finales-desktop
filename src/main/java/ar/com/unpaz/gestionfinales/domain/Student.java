package ar.com.unpaz.gestionfinales.domain;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Objects.requireNonNull;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Student extends Entity {

  public static String ERROR_DNI_MSG = "DNI invalido";
  public static String ERROR_NAME_MSG = "Ingrese nombre";
  public static String ERROR_SURNAME_MSG = "Ingrese apellido";
  public static String ERROR_EMAIL_MSG = "Ingrese email";
  public static String NO_ERROR = "";

  public final static Student EMPTY = new Student(0, "", "", "");

  public static String validateFieldsOf(Student student) {
    if (!isDNI(student.getDni())) {
      return ERROR_DNI_MSG;
    }
    if (student.getName().isEmpty()) {
      return ERROR_NAME_MSG;
    }
    if (student.getSurname().isEmpty()) {
      return ERROR_SURNAME_MSG;
    }
    if (student.getEmail().isEmpty()) {
      return ERROR_EMAIL_MSG;
    }
    return NO_ERROR;
  }

  private static boolean isDNI(String strDni) {
    return compile("[\\d$]{7,8}").matcher(strDni).matches();
  }

  private final String dni;
  private final String name;
  private final String surname;
  private final String email;

  public Student(int dni, String name, String surname, String email) {
    super(dni);
    this.dni = valueOf(dni);
    this.name = requireNonNull(name);
    this.surname = requireNonNull(surname);
    this.email = requireNonNull(email);
  }

  public Student(String dni, String name, String surname, String email) {
    super(0);
    this.dni = dni;
    this.name = name;
    this.surname = surname;
    this.email = email;
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

  public String getFullName() {
    return format("%s %s", getName(), getSurname());
  }

  public String getEmail() {
    return email;
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }

}
