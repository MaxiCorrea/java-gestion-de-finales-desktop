package ar.com.unpaz.gestionfinales.presentation;

import ar.com.unpaz.gestionfinales.usecase.AppController;

public interface AppView {
  
  void setController(AppController controller);
  
  void show();
  
  void close();
  
}
