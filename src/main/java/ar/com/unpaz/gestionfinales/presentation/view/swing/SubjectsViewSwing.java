package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext.subjectController;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.ADD;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.DELETE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.UPDATE;
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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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
import ar.com.unpaz.gestionfinales.presentation.model.YearCombo;
import ar.com.unpaz.gestionfinales.presentation.view.SubjectView;
import ar.com.unpaz.gestionfinales.presentation.view.swing.tables.SubjectTableModel;

public class SubjectsViewSwing implements SubjectView {

  private static final Color HEADER_COLOR = new Color(0, 133, 198);
  
  private JDialog dialog;
  private JTable tableSubjects;
  private JComboBox<YearCombo> comboxYear;
  private JButton buttonAdd;
  private JButton buttonUpdate;
  private JButton buttonDelete;
  private SubjectTableModel tableModel;

  public SubjectsViewSwing() {
    dialog = new JDialog();
    dialog.setResizable(false);
    dialog.setModal(true);
    dialog.setSize(600, 300);
    dialog.setTitle("Materias");
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
    tableModel = new SubjectTableModel();
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
    buttonAdd = new JButton(load(ADD));
    buttonAdd.setText("Agregar");
    buttonAdd.setBackground(WHITE);
    buttonAdd.setFocusPainted(false);
    buttonAdd.addActionListener((ActionEvent e) -> {
      subjectController.addSubject();
    });
    buttonUpdate = new JButton(load(UPDATE));
    buttonUpdate.setText("Modificar");
    buttonUpdate.setBackground(WHITE);
    buttonUpdate.setFocusPainted(false);
    buttonUpdate.addActionListener((ActionEvent e) -> {
      subjectController.updateSubject();
    });
    buttonDelete = new JButton(load(DELETE));
    buttonDelete.setText("Borrar");
    buttonDelete.setBackground(WHITE);
    buttonDelete.setFocusPainted(false);
    buttonDelete.addActionListener((ActionEvent e) -> {
      subjectController.deleteSubject();
    });
    pane.add(buttonUpdate);
    pane.add(buttonDelete);
    pane.add(buttonAdd);
    return pane;
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
