package ar.com.unpaz.gestionfinales.swing.students;

import java.io.File;
import javax.swing.JFileChooser;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.Report;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class ReportStudentDialogSwing implements Report<Student> {

  private static final String TITLE = "Ubicacion de Reporte de Alumnos";
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
  public Student get() {
    return null;
  }

  @Override
  public void set(Student e) {}

}
