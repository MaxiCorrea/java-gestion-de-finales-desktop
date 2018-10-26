package ar.com.unpaz.gestionfinales.presentation;

public interface AppView {
  
  void show();
  
  void close();

  void showError(String message);

  void showMessage(String string);
  
}
