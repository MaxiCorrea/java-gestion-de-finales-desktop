package ar.com.unpaz.gestionfinales.console;

import ar.com.unpaz.gestionfinales.presentation.AboutDialog;

public class AboutDialogConsole implements AboutDialog {
    
  private ConsoleWriter writer;
  
  public AboutDialogConsole() {
    writer = new ConsoleWriter();
  }
  
  public AboutDialogConsole(ConsoleWriter writer) {
    this.writer = writer;
  }
  
  @Override
  public void show() {
    writer.println(TITLE);
    writer.println(INFORMATION);
    writer.println(DEVELOPER);
    writer.println(EMAIL);
    writer.println(YEAR);
  }

}
