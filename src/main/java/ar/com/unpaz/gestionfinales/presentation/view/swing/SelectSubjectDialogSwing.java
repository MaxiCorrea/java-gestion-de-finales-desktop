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
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.controller.DialogController;
import ar.com.unpaz.gestionfinales.presentation.view.SelectSubjectDialog;
import ar.com.unpaz.gestionfinales.presentation.view.swing.tables.SimpleSubjectTableModel;

public class SelectSubjectDialogSwing implements SelectSubjectDialog {

  private static final Color HEADER_COLOR = new Color(0, 133, 198);

  private JDialog dialog;
  private JTable tableSubjects;
  private SimpleSubjectTableModel tableModel;
  private JButton acceptButton;
  private JButton cancelButton;

  public SelectSubjectDialogSwing() {
    dialog = new JDialog();
    dialog.setTitle("Seleccion Materia");
    dialog.setModal(true);
    dialog.setSize(300, 350);
    dialog.setResizable(false);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.getViewport().setBackground(WHITE);
    pane.setVerticalScrollBarPolicy(22);
    tableModel = new SimpleSubjectTableModel();
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
    pane.setBackground(WHITE);
    acceptButton = createButton("Aceptar");
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
    acceptButton.addActionListener((ActionEvent e) -> {
      controller.accept();
    });
    cancelButton.addActionListener((ActionEvent e) -> {
      controller.cancel();
    });
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

  @Override
  public void setSubjects(List<Subject> all) {
    tableModel.setSubjects(all);
  }

  @Override
  public int getSelectedRow() {
    return tableSubjects.getSelectedRow();
  }

  @Override
  public Subject getSubjectInRow(int row) {
    return tableModel.getInRow(row);
  }

  @Override
  public void close() {
    dialog.dispose();
  }

}
