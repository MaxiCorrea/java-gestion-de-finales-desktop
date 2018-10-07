package ar.com.unpaz.gestionfinales.domain;

public class Subject extends Entity {

  private final String description;
  private final int year;

  public Subject(String description, int year) {
    this(0, description, year);
  }

  public Subject(int id, String description, int year) {
    super(id);
    this.description = description;
    this.year = year;
  }

  public String getDescription() {
    return description;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return getId() + " " + getDescription();
  }

}
