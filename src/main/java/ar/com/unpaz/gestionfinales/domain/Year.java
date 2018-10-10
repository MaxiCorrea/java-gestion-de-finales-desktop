package ar.com.unpaz.gestionfinales.domain;

public enum Year {

  FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5);

  public final int number;

  private Year(int number) {
    this.number = number;
  }

  public static Year of(int year) {
    return values()[year - 1];
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

}
