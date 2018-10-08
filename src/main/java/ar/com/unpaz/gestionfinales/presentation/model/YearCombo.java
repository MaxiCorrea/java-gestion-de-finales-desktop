package ar.com.unpaz.gestionfinales.presentation.model;

public enum YearCombo {

  SELECT("Seleccione"),

  FIRST("Primero"),

  SECOND("Segundo"),

  THIRD("Tercero"),

  FOURTH("Cuarto"),

  FIFTH("Quinto");

  public final String name;

  private YearCombo(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ordinal() + " - " + name;
  }
}
