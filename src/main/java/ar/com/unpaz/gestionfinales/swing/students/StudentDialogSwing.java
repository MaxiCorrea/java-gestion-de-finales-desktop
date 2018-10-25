package ar.com.unpaz.gestionfinales.swing.students;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.Dialog;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class StudentDialogSwing implements Dialog<Student> {

  private static final int WIDTH_DIALOG = 300;
  private static final int HEIGHT_DIALOG = 280;

  private JDialog dialog;
  private JTextField dniField;
  private JTextField nameField;
  private JTextField surnameField;
  private JTextField emailField;
  private JButton acceptButton;
  private JButton cancelButton;
  private JLabel errorLabel;

  StudentDialogDataFor dataDialog;
  
  public StudentDialogSwing(StudentDialogDataFor dataDialog) {
    this.dataDialog = dataDialog;
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(WIDTH_DIALOG, HEIGHT_DIALOG);
    dialog.setResizable(false);
    dialog.setTitle(dataDialog.titleDialog());
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    dniField = new JTextField(25);
    dniField.setBorder(createTitledBorder("Dni"));
    dniField.setEnabled(dataDialog.dniFieldStatus());
    pane.add(dniField);
    nameField = new JTextField(25);
    nameField.setBorder(createTitledBorder("Nombre"));
    nameField.setEnabled(dataDialog.nameFieldStatus());
    pane.add(nameField);
    surnameField = new JTextField(25);
    surnameField.setBorder(createTitledBorder("Apellido"));
    surnameField.setEnabled(dataDialog.surnameFieldStatus());
    pane.add(surnameField);
    emailField = new JTextField(25);
    emailField.setBorder(createTitledBorder("Email"));
    emailField.setEnabled(dataDialog.emailFieldStatus());
    pane.add(emailField);
    errorLabel = new JLabel("", JLabel.CENTER);
    errorLabel.setForeground(RED);
    pane.add(errorLabel);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    acceptButton = createButton(dataDialog.buttonAcceptText());
    pane.add(acceptButton);
    cancelButton = createButton(dataDialog.buttonCancelText());
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
  public void set(Student student) {
    dniField.setText(student.getDni());
    nameField.setText(student.getName());
    surnameField.setText(student.getSurname());
    emailField.setText(student.getEmail());
  }

  @Override
  public Student get() {
    String dni = dniField.getText();
    String name = nameField.getText();
    String surname = surnameField.getText();
    String email = emailField.getText();
    return new Student(dni, name, surname, email);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

  @Override
  public void showError(String errorMessage) {
    errorLabel.setText(errorMessage);
  }

}
