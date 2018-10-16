package ar.com.unpaz.gestionfinales.domain;

public enum Qualification {

  NONE(0) ,ONE(1), TWO(2), THERE(3), FOR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10);

  public final int number;

  private Qualification(int number) {
    this.number = number;
  }

  public static Qualification of(int n) {
    return values()[n];
  }
  
  @Override
  public String toString() {
    return String.valueOf(number);
  }

}
