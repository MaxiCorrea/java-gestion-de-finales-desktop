package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.CANCEL;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.SAVE;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.DeleteSubjectDialog;

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
    acceptButton = new JButton(load(SAVE));
    acceptButton.setText("Guardar");
    pane.add(acceptButton);
    cancelButton = new JButton(load(CANCEL));
    cancelButton.setText("Cancelar");
    pane.add(cancelButton);
    return pane;
  }

  @Override
  public void setSubject(Subject selected) {
    idLabel.setText(String.valueOf(selected.getId()));
    descriptionLabel.setText(selected.getDescription());
    yearLabel.setText(String.valueOf(selected.getYear()));
  }

  @Override
  public void setController(DialogController controller) {
    acceptButton.addActionListener((ActionEvent e) -> {
      controller.accept();
    });
    cancelButton.addActionListener((ActionEvent e) -> {
      controller.cancel();
    });
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

  @Override
  public Subject getSubject() {
    int id = Integer.valueOf(idLabel.getText());
    String description = descriptionLabel.getText();
    int year = Integer.valueOf(yearLabel.getText());
    return new Subject(id, description, year);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
