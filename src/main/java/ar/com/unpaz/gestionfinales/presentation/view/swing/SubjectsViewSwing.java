package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext.subjectController;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.ADD;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.DELETE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.UPDATE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.FlowLayout.LEFT;
import static java.awt.event.ItemEvent.SELECTED;
import java.awt.BorderLayout;
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

  private JDialog dialog;
  private JTable tableSubjects;
  private JComboBox<YearCombo> comboxYear;
  private JButton buttonAdd;
  private JButton buttonUpdate;
  private JButton buttonDelete;

  public SubjectsViewSwing() {
    dialog = new JDialog();
    dialog.setResizable(false);
    dialog.setModal(true);
    dialog.setSize(500, 300);
    dialog.setTitle("Materias");
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createNorthPane(), NORTH);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createNorthPane() {
    JPanel pane = new JPanel(new FlowLayout(LEFT));
    comboxYear = new JComboBox<>(YearCombo.values());
    comboxYear.addItemListener((ItemEvent e) -> {
      if(e.getStateChange() == SELECTED) {
        subjectController.filterByYear();
      }
    });
    pane.add(new JLabel("Filtrar por año : "));
    pane.add(comboxYear);
    return pane;
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.setVerticalScrollBarPolicy(22);
    tableSubjects = new JTable(new SubjectTableModel());
    pane.setViewportView(tableSubjects);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    buttonAdd = new JButton(load(ADD));
    buttonAdd.setText("Agregar");
    buttonAdd.addActionListener((ActionEvent e) -> {
      subjectController.addSubject();
    });
    buttonUpdate = new JButton(load(UPDATE));
    buttonUpdate.setText("Modificar");
    buttonUpdate.addActionListener((ActionEvent e) -> {
      subjectController.updateSubject();
    });
    buttonDelete = new JButton(load(DELETE));
    buttonDelete.setText("Borrar");
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
    dialog.setLocationRelativeTo(dialog.getParent());
    dialog.setVisible(true);
  }

  @Override
  public void update(List<Subject> subjects) {
    ((SubjectTableModel) tableSubjects.getModel()).setSubjects(subjects);
  }

  @Override
  public YearCombo getSelectedYear() {
    return comboxYear.getItemAt(comboxYear.getSelectedIndex());
  }

}
