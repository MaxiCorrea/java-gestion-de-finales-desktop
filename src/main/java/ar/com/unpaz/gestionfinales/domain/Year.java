package ar.com.unpaz.gestionfinales.domain;

public class Year {

  private final int value;
  private final String description;

  public Year(int value, String description) {
    this.value = value;
    this.description = description;
  }

  public int getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return getValue() + "-" + getDescription();
  }

}
