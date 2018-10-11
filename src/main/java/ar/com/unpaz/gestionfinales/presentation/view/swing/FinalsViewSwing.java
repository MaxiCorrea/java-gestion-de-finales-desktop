package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.ADD;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.DELETE;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.UPDATE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.domain.Final;
import ar.com.unpaz.gestionfinales.presentation.controller.AppControllerContext;
import ar.com.unpaz.gestionfinales.presentation.view.FinalsView;
import ar.com.unpaz.gestionfinales.presentation.view.swing.tables.FinalTableModel;

public class FinalsViewSwing implements FinalsView {

  private static final int HEIGHT = 300;
  private static final int WIDTH = 600;
  private static final Color HEADER_COLOR = new Color(0, 133, 198);
  private static final String TITLE = "Finales";
  
  private JDialog dialog;
  private JTable tableFinals;
  private JButton buttonAdd;
  private JButton buttonUpdate;
  private JButton buttonDelete;
  private FinalTableModel tableModel;
  
  public FinalsViewSwing() {
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
    pane.setBackground(Color.blue);
    return pane;
  }

  private JScrollPane createCenterPane() {
    JScrollPane pane = new JScrollPane();
    pane.getViewport().setBackground(WHITE);
    pane.setVerticalScrollBarPolicy(22);
    tableModel = new FinalTableModel();
    tableFinals = new JTable(tableModel);
    tableFinals.setSelectionMode(SINGLE_SELECTION);
    tableFinals.getTableHeader().setBackground(HEADER_COLOR);
    tableFinals.getTableHeader().setForeground(WHITE);
    tableFinals.setBackground(WHITE);
    tableFinals.setForeground(BLACK);
    pane.setViewportView(tableFinals);
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
      AppControllerContext.finalController.addFinal();
    });
    buttonUpdate = new JButton(load(UPDATE));
    buttonUpdate.setText("Modificar");
    buttonUpdate.setBackground(WHITE);
    buttonUpdate.setFocusPainted(false);
    buttonUpdate.addActionListener((ActionEvent e) -> {
      AppControllerContext.finalController.updateFinal();
    });
    buttonDelete = new JButton(load(DELETE));
    buttonDelete.setText("Borrar");
    buttonDelete.setBackground(WHITE);
    buttonDelete.setFocusPainted(false);
    buttonDelete.addActionListener((ActionEvent e) -> {
      AppControllerContext.finalController.deleteFinal();
    });
    pane.add(buttonUpdate);
    pane.add(buttonDelete);
    pane.add(buttonAdd);
    return pane;
  }
  
  @Override
  public int getSelectedRow() {
    return tableFinals.getSelectedRow();
  }

  @Override
  public Final getFinalInRow(int row) {
    return tableModel.getInRow(row);
  }

  @Override
  public void setFinals(List<Final> finals) {
    tableModel.setFinals(finals);
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

}
