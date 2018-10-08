package ar.com.unpaz.gestionfinales.presentation.view;

public interface SubjectAddDialog {

  String getDescription();

  int getYear();

  void show();

  void close();

  void clearDescription();

  void resetYear();

  void message(String message);

}
