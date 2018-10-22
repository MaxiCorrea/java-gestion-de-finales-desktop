package ar.com.unpaz.gestionfinales.swing.finals;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import static java.lang.String.valueOf;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.finals.DeleteFinalDialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteFinalDialogSwing implements DeleteFinalDialog {

  private JDialog dialog;
  private JLabel idLabel;
  private JLabel qualificationLabel;
  private JLabel subjectLabel;
  private JLabel studentLabel;
  private JButton acceptButton;
  private JButton cancelButton;
  private Final finalObj;

  public DeleteFinalDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(300, 280);
    dialog.setResizable(false);
    dialog.setTitle("Eliminar Final");
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    idLabel = new JLabel("", JLabel.CENTER);
    qualificationLabel = new JLabel("", JLabel.CENTER);
    subjectLabel = new JLabel("", JLabel.CENTER);
    studentLabel = new JLabel("", JLabel.CENTER);
    pane.add(new JLabel("Id : "));
    pane.add(idLabel);
    pane.add(new JLabel("Nota : "));
    pane.add(qualificationLabel);
    pane.add(new JLabel("Materia : "));
    pane.add(subjectLabel);
    pane.add(new JLabel("Alumno : "));
    pane.add(studentLabel);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    acceptButton = createButton("Guardar");
    pane.add(acceptButton);
    cancelButton = createButton("Cancelar");
    pane.add(cancelButton);
    return pane;
  }

  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setBackground(BUTTON_BACKGROUND_COLOR);
    button.setForeground(BUTTON_FOREGROUND_COLOR);
    button.setPreferredSize(new Dimension(105, 25));
    button.setFocusPainted(false);
    return button;
  }

  @Override
  public void setFinal(Final finalObj) {
    this.finalObj = finalObj;
    idLabel.setText(valueOf(finalObj.getId()));
    qualificationLabel.setText(valueOf(finalObj.getQualification().number));
    subjectLabel.setText(finalObj.getSubject().getDescription());
    studentLabel.setText(finalObj.getStudent().getFullName());
  }

  @Override
  public Final getFinal() {
    return finalObj;
  }

  @Override
  public void setController(DialogController controller) {
    acceptButton.addActionListener((e) -> {
      controller.accept();
    });
    cancelButton.addActionListener((e) -> {
      controller.cancel();
    });
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.repaint();
    dialog.setVisible(true);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
