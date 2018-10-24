package ar.com.unpaz.gestionfinales.swing.finals;

import java.io.File;
import javax.swing.JFileChooser;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.Report;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportFinalDialogSwing implements Report<Final> {

  private static final String TITLE = "Ubicacion de Reporte de Finales";
  private JFileChooser chooser;
  private File fileSelected;
  private DialogController controller;

  public ReportFinalDialogSwing() {
    chooser = new JFileChooser();
    chooser.setDialogTitle(TITLE);
  }

  @Override
  public void setController(DialogController controller) {
    this.controller = controller;
  }

  @Override
  public void show() {
    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      fileSelected = chooser.getSelectedFile();
      controller.accept();
    }
  }

  @Override
  public File getFile() {
    return fileSelected;
  }

  @Override
  public void close() {}

  @Override
  public void showError(String message) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Final get() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void set(Final e) {
    // TODO Auto-generated method stub
    
  }
  
}
