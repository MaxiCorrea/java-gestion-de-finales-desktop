package ar.com.unpaz.gestionfinales.swing.subjects;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.RED;
import static javax.swing.BorderFactory.createTitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.presentation.subjects.AddSubjectDialog;
import ar.com.unpaz.gestionfinales.presentation.subjects.YearCombo;
import ar.com.unpaz.gestionfinales.usecase.DialogController;

public class AddSubjectDialogSwing implements AddSubjectDialog {

  private static final String TITLE = "Nueva Materia";
  
  private JDialog dialog;
  private JTextField fieldDescription;
  private JComboBox<YearCombo> comboYear;
  private JButton acceptButton;
  private JButton cancelButton;
  private JLabel errorMessage;

  public AddSubjectDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setSize(420, 170);
    dialog.setResizable(false);
    dialog.setTitle(TITLE);
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel(new BorderLayout());
    comboYear = new JComboBox<>(YearCombo.values());
    comboYear.setBorder(createTitledBorder("Año"));
    pane.add(comboYear, NORTH);
    fieldDescription = new JTextField();
    fieldDescription.setBorder(createTitledBorder("Descripcion"));
    JScrollPane scrollPane = new JScrollPane(fieldDescription);
    scrollPane.setPreferredSize(new Dimension(5, 40));
    pane.add(scrollPane, CENTER);
    errorMessage = new JLabel("", JLabel.CENTER);
    errorMessage.setForeground(RED);
    pane.add(errorMessage, SOUTH);
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

  @Override
  public Subject getSubject() {
    String description = fieldDescription.getText();
    int index = comboYear.getSelectedIndex();
    return new Subject(description, Year.of(index));
  }

  @Override
  public void setSubject(Subject subject) {
    fieldDescription.setText(subject.getDescription());
    comboYear.setSelectedIndex(subject.getYear().number);
  }
  
  @Override
  public void showError(String message) {
    errorMessage.setText(message);
  }
  
}
