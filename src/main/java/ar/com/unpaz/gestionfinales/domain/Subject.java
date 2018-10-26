package ar.com.unpaz.gestionfinales.domain;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Subject extends Entity<Subject> {
  
  public static final int MAX_NUMBER_OF_CHARACTERS = 50;
  public static final Subject EMPTY = new Subject();
  
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

  public boolean haveThisYear(Year year) {
    return getYear() == year;
  }
  
  public boolean hasEmptyDescription() {
    return getDescription().isEmpty();
  }
  
  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
  
  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return "Subject [description=" + description + ", year=" + year + "]";
  }
  
}
