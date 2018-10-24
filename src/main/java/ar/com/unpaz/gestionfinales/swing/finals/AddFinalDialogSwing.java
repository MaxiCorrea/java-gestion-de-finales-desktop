package ar.com.unpaz.gestionfinales.swing.finals;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.domain.Qualification;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.finals.FinalDialog;
import ar.com.unpaz.gestionfinales.presentation.finals.QualificationCombo;
import ar.com.unpaz.gestionfinales.usecase.DialogController;
import ar.com.unpaz.gestionfinales.usecase.finals.FinalDialogController;

public class AddFinalDialogSwing implements FinalDialog {

  private JDialog dialog;
  private JButton selectSubjectButton;
  private JTextField selectedSubjectField;
  private JButton selectStudentButton;
  private JTextField selectedStudentField;
  private JComboBox<QualificationCombo> comboQualification;
  private JButton acceptButton;
  private JButton cancelButton;
  private JLabel errorLabel;

  private Subject selectedSubject;
  private Student selectedStudent;

  public AddFinalDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(300, 280);
    dialog.setResizable(false);
    dialog.setTitle("Nuevo Final");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    comboQualification = new JComboBox<>(QualificationCombo.values());
    comboQualification.setBackground(WHITE);
    pane.add(comboQualification);
    pane.add(createSubPanelSubject());
    pane.add(createSubPanelStudent());
    errorLabel = new JLabel("",JLabel.CENTER);
    errorLabel.setForeground(RED);
    pane.add(errorLabel);
    return pane;
  }

  private JPanel createSubPanelSubject() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.setBorder(createTitledBorder("Materia"));
    selectSubjectButton = createButton("Seleccionar");
    selectedSubjectField = new JTextField(12);
    selectedSubjectField.setEditable(false);
    pane.add(selectSubjectButton);
    pane.add(selectedSubjectField);
    return pane;
  }

  private JPanel createSubPanelStudent() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.setBorder(createTitledBorder("Alumno"));
    selectStudentButton = createButton("Seleccionar");
    selectedStudentField = new JTextField(12);
    selectedStudentField.setEditable(false);
    pane.add(selectStudentButton);
    pane.add(selectedStudentField);
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
  public void set(Final finalObj) {
    comboQualification.setSelectedIndex(finalObj.getQualification().number);
    selectedStudentField.setText(finalObj.getStudent().getName());
    selectedStudent = finalObj.getStudent();
    selectedSubjectField.setText(finalObj.getSubject().getDescription());
    selectedSubject = finalObj.getSubject();
    comboQualification.setSelectedIndex(finalObj.getQualification().number);
  }

  @Override
  public Final get() {
    return new Final(0, selectedSubject, selectedStudent, LocalDate.now(),
        Qualification.of(comboQualification.getSelectedIndex()));
  }

  @Override
  public void setController(DialogController controller) {
    FinalDialogController c = (FinalDialogController) controller;
    selectStudentButton.addActionListener((e) -> {
      c.selectStudent();
    });
    selectSubjectButton.addActionListener((e) -> {
      c.selectSubject();
    });
    acceptButton.addActionListener((e) -> {
      c.accept();
    });
    cancelButton.addActionListener((e) -> {
      c.cancel();
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

  @Override
  public void setSubject(Subject subject) {
    selectedSubject = subject;
    selectedSubjectField.setText(subject.getDescription());
  }

  @Override
  public void setStudent(Student student) {
    selectedStudent = student;
    selectedStudentField.setText(student.getFullName());
  }

  @Override
  public void showError(String errorMessage) {
    this.errorLabel.setText(errorMessage);
  }

}
