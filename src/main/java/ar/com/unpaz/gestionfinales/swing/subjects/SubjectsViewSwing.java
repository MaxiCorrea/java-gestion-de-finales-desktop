package ar.com.unpaz.gestionfinales.swing.subjects;

import static ar.com.unpaz.gestionfinales.application.AppControllerContext.subjectController;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_BACKGROUND_COLOR;
import static ar.com.unpaz.gestionfinales.swing.ColorConstants.BUTTON_FOREGROUND_COLOR;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.FlowLayout.LEFT;
import static java.awt.event.ItemEvent.SELECTED;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectsView;
import ar.com.unpaz.gestionfinales.presentation.subjects.YearCombo;

public class SubjectsViewSwing implements SubjectsView {

  private static final int HEIGHT = 300;
  private static final int WIDTH = 600;
  private static final Color HEADER_COLOR = new Color(0, 133, 198);
  private static final String TITLE = "Materias";

  private JDialog dialog;
  private JTable tableSubjects;
  private JComboBox<YearCombo> comboxYear;
  private SubjectTableModelSwing tableModel;

  public SubjectsViewSwing() {
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
    JPanel pane = new JPanel(new FlowLayout(LEFT));
    pane.setBackground(Color.WHITE);
    comboxYear = new JComboBox<>(YearCombo.values());
    comboxYear.setBackground(WHITE);
    comboxYear.addItemListener((ItemEvent e) -> {
      if (e.getStateChange() == SELECTED) {
        subjectController.filterByYear();
      }
    });
    pane.add(new JLabel("Filtrar por año : "));
    pane.add(comboxYear);
    return pane;
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.getViewport().setBackground(WHITE);
    pane.setVerticalScrollBarPolicy(22);
    tableModel = new SubjectTableModelSwing();
    tableSubjects = new JTable(tableModel);
    tableSubjects.setSelectionMode(SINGLE_SELECTION);
    tableSubjects.getTableHeader().setBackground(HEADER_COLOR);
    tableSubjects.getTableHeader().setForeground(WHITE);
    tableSubjects.setBackground(WHITE);
    tableSubjects.setForeground(BLACK);
    pane.setViewportView(tableSubjects);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    pane.setBackground(Color.WHITE);
    JButton buttonAdd = createButton("Agregar");
    buttonAdd.addActionListener((e) -> {
      subjectController.addSubject();
    });
    JButton buttonUpdate = createButton("Modificar");
    buttonUpdate.addActionListener((e) -> {
      subjectController.updateSubject();
    });
    JButton buttonDelete = createButton("Borrar");
    buttonDelete.addActionListener((e) -> {
      subjectController.deleteSubject();
    });
    JButton buttonReport = createButton("Reporte");
    buttonReport.addActionListener((e)->{
      subjectController.generateReport();
    });
    pane.add(buttonUpdate);
    pane.add(buttonReport);
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
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

  @Override
  public void setSubjects(List<Subject> subjects) {
    tableModel.setSubjects(subjects);
  }

  @Override
  public int getSelectedRow() {
    return tableSubjects.getSelectedRow();
  }

  @Override
  public Subject getSubjectInRow(int rowIndex) {
    return tableModel.getInRow(rowIndex);
  }

  @Override
  public YearCombo getYearSelected() {
    return comboxYear.getItemAt(comboxYear.getSelectedIndex());
  }

}
