package ar.com.unpaz.gestionfinales.swing.subjects;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.presentation.subjects.DeleteSubjectDialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class DeleteSubjectDialogSwing implements DeleteSubjectDialog {

  private JDialog dialog;
  private JLabel descriptionLabel;
  private JLabel idLabel;
  private JLabel yearLabel;
  private JButton acceptButton;
  private JButton cancelButton;

  public DeleteSubjectDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(420, 150);
    dialog.setResizable(false);
    dialog.setTitle("Borrar Materia");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), NORTH);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.add(new JLabel("id : "));
    idLabel = new JLabel();
    pane.add(idLabel);
    pane.add(new JLabel("Description : "));
    descriptionLabel = new JLabel();
    pane.add(descriptionLabel);
    pane.add(new JLabel("Año : "));
    yearLabel = new JLabel();
    pane.add(yearLabel);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
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
  public void setSubject(Subject selected) {
    idLabel.setText(String.valueOf(selected.getId()));
    descriptionLabel.setText(selected.getDescription());
    yearLabel.setText(String.valueOf(selected.getYear()));
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
  public Subject getSubject() {
    int id = Integer.valueOf(idLabel.getText());
    String description = descriptionLabel.getText();
    int year = Integer.valueOf(yearLabel.getText());
    return new Subject(id, description, Year.of(year));
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
