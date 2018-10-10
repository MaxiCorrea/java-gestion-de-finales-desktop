package ar.com.unpaz.gestionfinales.domain;

public class Subject extends Entity {

  public static final Subject EMPTY = new Subject("", Year.FIRST);

  private final String description;
  private final Year year;

  public Subject(String description, Year year) {
    this(0, description, year);
  }

  public Subject(int id, String description, Year year) {
    super(id);
    this.description = description;
    this.year = year;
  }

  public String getDescription() {
    return description;
  }

  public Year getYear() {
    return year;
  }

}
