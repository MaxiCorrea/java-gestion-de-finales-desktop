package ar.com.unpaz.gestionfinales.domain;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Subject extends Entity {

  public static String YEAR_ERROR_MSG = "Seleccione el año";
  public static String DESC_ERROR_MSG = "ingrese descripcion";
  public static String NO_ERROR = "";

  public static final Subject EMPTY = new Subject();

  public static String validateFieldsOf(Subject subject) {
    if (subject.getYear() == Year.NONE) {
      return YEAR_ERROR_MSG;
    }
    if (subject.getDescription().isEmpty()) {
      return DESC_ERROR_MSG;
    }
    return NO_ERROR;
  }

  private final String description;
  private final Year year;

  public Subject() {
    this(0,"" , Year.NONE);
  }
  
  public Subject(String description, Year year) {
    this(0, description, year);
  }

  public Subject(int id, String description, Year year) {
    super(id);
    this.description = requireNonNull(description);
    this.year = requireNonNull(year);
  }

  public String getDescription() {
    return description;
  }

  public Year getYear() {
    return year;
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
