package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.SelectStudentDialog;
import ar.com.unpaz.gestionfinales.presentation.view.swing.tables.SimpleStudentTableModel;

public class SelectStudentDialogSwing implements SelectStudentDialog {

  private static final Color HEADER_COLOR = new Color(0, 133, 198);
  
  private JDialog dialog;
  private JTable tableStudents;
  private SimpleStudentTableModel tableModel;
  private JButton acceptButton;
  private JButton cancelButton;
  
  public SelectStudentDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setTitle("Seleccione Alumno");
    dialog.setSize(300,350);
    dialog.setResizable(false);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }
  
  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.getViewport().setBackground(WHITE);
    pane.setVerticalScrollBarPolicy(22);
    tableModel = new SimpleStudentTableModel();
    tableStudents = new JTable(tableModel);
    tableStudents.setSelectionMode(SINGLE_SELECTION);
    tableStudents.getTableHeader().setBackground(HEADER_COLOR);
    tableStudents.getTableHeader().setForeground(WHITE);
    tableStudents.setBackground(WHITE);
    tableStudents.setForeground(BLACK);
    pane.setViewportView(tableStudents);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    acceptButton = createButton("Aceptar");
    cancelButton = createButton("Cancelar");
    pane.add(acceptButton);
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
    acceptButton.addActionListener((ActionEvent e) ->{
      controller.accept();
    });
    cancelButton.addActionListener((ActionEvent e) ->{
      controller.cancel();
    });
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

  @Override
  public int getSelectedRow() {
    return tableStudents.getSelectedRow();
  }

  @Override
  public Student getStudentInRow(int row) {
    return tableModel.getInRow(row);
  }

  @Override
  public void setStudents(List<Student> students) {
    tableModel.setStudents(students);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
