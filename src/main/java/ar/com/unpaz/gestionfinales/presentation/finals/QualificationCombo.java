package ar.com.unpaz.gestionfinales.presentation.finals;

public enum QualificationCombo {

  NONE("Seleccionar"),

  ONE("1 (Uno)"),

  TWO("2 (Dos)"),

  THERE("3 (Tres)"),

  FOR("4 (Cuatro)"),

  FIVE("5 (Cinco)"),

  SIX("6 (Seis)"),

  SEVEN("7 (Siete)"),

  EIGHT("8 (Ocho)"),

  NINE("9 (Nueve)"),

  TEN("10 (Diez)");

  private final String name;

  private QualificationCombo(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

}
