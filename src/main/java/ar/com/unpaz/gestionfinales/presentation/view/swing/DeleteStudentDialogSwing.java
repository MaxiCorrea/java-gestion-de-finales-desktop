package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.CANCEL;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.SAVE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.DeleteStudentDialog;

public class DeleteStudentDialogSwing implements DeleteStudentDialog {

  private JDialog dialog;
  private JTextField dniField;
  private JTextField nameField;
  private JTextField surnameField;
  private JTextField emailField;
  private JButton acceptButton;
  private JButton cancelButton;

  public DeleteStudentDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(300, 280);
    dialog.setResizable(false);
    dialog.setTitle("Borrar Alumno");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    dniField = new JTextField(25);
    dniField.setEnabled(false);
    dniField.setBorder(createTitledBorder("Dni"));
    pane.add(dniField);
    nameField = new JTextField(25);
    nameField.setEnabled(false);
    nameField.setBorder(createTitledBorder("Nombre"));
    pane.add(nameField);
    surnameField = new JTextField(25);
    surnameField.setEnabled(false);
    surnameField.setBorder(createTitledBorder("Apellido"));
    pane.add(surnameField);
    emailField = new JTextField(25);
    emailField.setEnabled(false);
    emailField.setBorder(createTitledBorder("Email"));
    pane.add(emailField);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    acceptButton = new JButton(load(SAVE));
    acceptButton.setText("Guardar");
    pane.add(acceptButton);
    cancelButton = new JButton(load(CANCEL));
    cancelButton.setText("Cancelar");
    pane.add(cancelButton);
    return pane;
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
  public void setStudent(Student student) {
    dniField.setText(String.valueOf(student.getId()));
    nameField.setText(student.getName());
    surnameField.setText(student.getSurname());
    emailField.setText(student.getEmail());
  }

  @Override
  public Student getStudent() {
    int dni = Integer.valueOf(dniField.getText());
    String name = nameField.getText();
    String surname = surnameField.getText();
    String email = emailField.getText();
    return new Student(dni, name, surname, email);
  }

  @Override
  public void close() {
    dialog.dispose();
  }
}
