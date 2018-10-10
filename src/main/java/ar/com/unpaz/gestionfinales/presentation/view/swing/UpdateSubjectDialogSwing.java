package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.CANCEL;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.SAVE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.UpdateSubjectDialog;

public class UpdateSubjectDialogSwing implements UpdateSubjectDialog {

  private JDialog dialog;
  private JTextField fieldDescription;
  private JSpinner spinnerYear;
  private JButton okButton;
  private JButton cancelButton;
  private int id;

  public UpdateSubjectDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(420, 150);
    dialog.setResizable(false);
    dialog.setTitle("Actualizar Materia");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), NORTH);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel(new BorderLayout());
    spinnerYear = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
    spinnerYear.setBorder(createTitledBorder("Año"));
    pane.add(spinnerYear, NORTH);
    fieldDescription = new JTextField();
    fieldDescription.setBorder(createTitledBorder("Descripcion"));
    JScrollPane scrollPane = new JScrollPane(fieldDescription);
    scrollPane.setPreferredSize(new Dimension(5, 40));
    pane.add(scrollPane, CENTER);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    okButton = new JButton(load(SAVE));
    okButton.setText("Guardar");
    pane.add(okButton);
    cancelButton = new JButton(load(CANCEL));
    cancelButton.setText("Cancelar");
    pane.add(cancelButton);
    return pane;
  }

  @Override
  public void setController(DialogController controller) {
    okButton.addActionListener((ActionEvent e) -> {
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
    String description = fieldDescription.getText();
    int year = (int) spinnerYear.getValue();
    return new Subject(id, description, Year.of(year));
  }

  @Override
  public void setSubject(Subject selected) {
    this.id = selected.getId();
    fieldDescription.setText(selected.getDescription());
    spinnerYear.setValue(selected.getYear().number);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
