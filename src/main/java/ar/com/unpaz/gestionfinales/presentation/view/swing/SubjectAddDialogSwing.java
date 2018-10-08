package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext.subjectAddDialogController;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.CANCEL;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.SAVE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.lang.Integer.valueOf;
import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.JOptionPane.showMessageDialog;
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
import ar.com.unpaz.gestionfinales.presentation.view.SubjectAddDialog;

public class SubjectAddDialogSwing implements SubjectAddDialog {

  private JDialog dialog;
  private JTextField fieldDescription;
  private JSpinner spinnerYear;
  private JButton okButton;
  private JButton cancelButton;

  public SubjectAddDialogSwing() {
    dialog = new JDialog();
    dialog.setResizable(false);
    dialog.setModal(true);
    dialog.setBounds(100, 100, 420, 150);
    dialog.setTitle("Nueva Materia");
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
    okButton.addActionListener((ActionEvent e) -> {
      subjectAddDialogController.save();
    });
    pane.add(okButton);
    cancelButton = new JButton(load(CANCEL));
    cancelButton.setText("Cancelar");
    cancelButton.addActionListener((ActionEvent e) -> {
      subjectAddDialogController.cancel();
    });
    pane.add(cancelButton);
    return pane;
  }

  @Override
  public String getDescription() {
    return fieldDescription.getText();
  }

  @Override
  public int getYear() {
    return (int) spinnerYear.getValue();
  }

  @Override
  public void message(String message) {
    showMessageDialog(null, message);
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(dialog.getParent());
    dialog.setVisible(true);
  }

  @Override
  public void close() {
    dialog.setVisible(false);
    dialog.dispose();
  }

  @Override
  public void clearDescription() {
    fieldDescription.setText("");
  }

  @Override
  public void resetYear() {
    spinnerYear.setValue(valueOf("1"));
  }

}
