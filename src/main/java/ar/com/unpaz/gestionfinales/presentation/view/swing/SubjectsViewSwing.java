package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext.subjectController;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.ADD;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.CANCEL;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.DELETE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.SAVE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.UPDATE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.FlowLayout.LEFT;
import static java.awt.event.ItemEvent.SELECTED;
import static java.lang.Integer.valueOf;
import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
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

  private SubjectAddDialogSwing addDialog;

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
    addDialog = new SubjectAddDialogSwing();
  }

  private JPanel createNorthPane() {
    JPanel pane = new JPanel(new FlowLayout(LEFT));
    comboxYear = new JComboBox<>(YearCombo.values());
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

  @Override
  public String getDescription() {
    return addDialog.getDescription();
  }

  @Override
  public int getYear() {
    return addDialog.getYear();
  }

  @Override
  public void showDialog() {
    addDialog.show();
  }

  @Override
  public void closeDialog() {
    addDialog.close();
  }

  @Override
  public void clearDescription() {
    addDialog.clearDescription();
  }

  @Override
  public void resetYear() {
    addDialog.resetYear();
  }

  @Override
  public void message(String message) {
    addDialog.message(message);
  }

  private class SubjectAddDialogSwing {

    private JDialog dialog;
    private JTextField fieldDescription;
    private JSpinner spinnerYear;
    private JButton okButton;
    private JButton cancelButton;

    public SubjectAddDialogSwing() {
      dialog = new JDialog();
      dialog.setResizable(false);
      dialog.setModal(true);
      dialog.setBounds(100, 100, 420, 150);
      dialog.setTitle("Nueva Materia");
      dialog.getContentPane().setLayout(new BorderLayout());
      dialog.getContentPane().add(createCenterPane(), NORTH);
      dialog.getContentPane().add(createSouthPane(), SOUTH);
    }

    private JPanel createCenterPane() {
      JPanel pane = new JPanel(new BorderLayout());
      spinnerYear = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
      spinnerYear.setBorder(createTitledBorder("Año"));
      pane.add(spinnerYear, NORTH);
      fieldDescription = new JTextField();
      fieldDescription.setBorder(createTitledBorder("Descripcion"));
      JScrollPane scrollPane = new JScrollPane(fieldDescription);
      scrollPane.setPreferredSize(new Dimension(5, 40));
      pane.add(scrollPane, CENTER);
      return pane;
    }

    private JPanel createSouthPane() {
      JPanel pane = new JPanel();
      okButton = new JButton(load(SAVE));
      okButton.setText("Guardar");
      okButton.addActionListener((ActionEvent e) -> {
        subjectController.save();
      });
      pane.add(okButton);
      cancelButton = new JButton(load(CANCEL));
      cancelButton.setText("Cancelar");
      cancelButton.addActionListener((ActionEvent e) -> {
        subjectController.cancel();
      });
      pane.add(cancelButton);
      return pane;
    }

    public String getDescription() {
      return fieldDescription.getText();
    }

    public int getYear() {
      return (int) spinnerYear.getValue();
    }

    public void message(String message) {
      showMessageDialog(null, message);
    }

    public void show() {
      dialog.setLocationRelativeTo(SubjectsViewSwing.this.dialog);
      dialog.setVisible(true);
    }

    public void close() {
      dialog.setVisible(false);
      dialog.dispose();
    }

    public void clearDescription() {
      fieldDescription.setText("");
    }

    public void resetYear() {
      spinnerYear.setValue(valueOf("1"));
    }

  }

}
