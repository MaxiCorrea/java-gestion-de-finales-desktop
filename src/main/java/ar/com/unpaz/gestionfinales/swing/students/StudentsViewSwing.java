package ar.com.unpaz.gestionfinales.swing.students;

import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.application.AppControllerContext;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.students.StudentsView;

public class StudentsViewSwing implements StudentsView {

  private static final int HEIGHT = 300;
  private static final int WIDTH = 600;
  private static final Color HEADER_COLOR = new Color(0, 133, 198);
  private static final String TITLE = "Alumnos";

  private JDialog dialog;
  private JTable tableStudents;
  private StudentTableModelSwing tableModel;

  public StudentsViewSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setTitle(TITLE);
    dialog.setSize(WIDTH, HEIGHT);
    dialog.setResizable(false);
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createNorthPane(), NORTH);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createNorthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(Color.WHITE);
    return pane;
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.getViewport().setBackground(WHITE);
    pane.setVerticalScrollBarPolicy(22);
    tableModel = new StudentTableModelSwing();
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
    pane.setBackground(Color.WHITE);
    JButton buttonAdd = createButton("Agregar");
    buttonAdd.addActionListener((e) -> {
      AppControllerContext.studentController.addStudent();
    });
    JButton buttonUpdate = createButton("Modificar");
    buttonUpdate.addActionListener((e) -> {
      AppControllerContext.studentController.updateStudent();
    });
    JButton buttonDelete = createButton("Borrar");
    buttonDelete.addActionListener((e) -> {
      AppControllerContext.studentController.deleteStudent();
    });
    pane.add(buttonUpdate);
    pane.add(buttonDelete);
    pane.add(buttonAdd);
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
  public int getSelectedRow() {
    return tableStudents.getSelectedRow();
  }

  @Override
  public Student getStudentInRow(int row) {
    return tableModel.getInRow(row);
  }

  @Override
  public void setStudents(List<Student> all) {
    tableModel.setStudents(all);
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

}
