package ar.com.unpaz.gestionfinales.swing.subjects;

import java.io.File;
import javax.swing.JFileChooser;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.Report;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportSubjectDialogSwing implements Report<Subject> {

  private static final String TITLE = "Ubicacion de Reporte de Materias";
  private File fileSelected;
  private DialogController controller;

  @Override
  public void setController(DialogController controller) {
    this.controller = controller;
  }

  @Override
  public void show() {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle(TITLE);
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
  public void showError(String message) {}

  @Override
  public Subject get() {
    return null;
  }

  @Override
  public void set(Subject e) {}

}
