package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource.IconPathOf.ADD;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource.IconPathOf.DELETE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.IconResource.IconPathOf.UPDATE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.FlowLayout.LEFT;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.presentation.view.StudentView;

public class StudentsViewSwing implements StudentView {
  
  private JDialog dialog;
  private JTable tableSubjects;
  private JComboBox<Year> comboxYear;
  private JButton buttonAdd;
  private JButton buttonUpdate;
  private JButton buttonDelete;

  public StudentsViewSwing() {
    dialog = new JDialog();
    dialog.setTitle("Alumnos");
    dialog.setModal(true);
    dialog.setSize(300, 300);
    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(createNorthPane(), NORTH);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createNorthPane() {
    JPanel pane = new JPanel(new FlowLayout(LEFT));
    comboxYear = new JComboBox<>();
    pane.add(comboxYear);
    return pane;
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.setVerticalScrollBarPolicy(22);
    tableSubjects = new JTable();
    pane.setViewportView(tableSubjects);
    return pane;
  }

  private JPanel createSouthPane() {
    JPanel pane = new JPanel();
    buttonAdd = new JButton(load(ADD));
    buttonUpdate = new JButton(load(UPDATE));
    buttonDelete = new JButton(load(DELETE));
    pane.add(buttonAdd);
    pane.add(buttonUpdate);
    pane.add(buttonDelete);
    return pane;
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(dialog.getParent());
    dialog.setVisible(true);
  }

}
