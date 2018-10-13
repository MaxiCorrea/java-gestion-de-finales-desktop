package ar.com.unpaz.gestionfinales.presentation.finals;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ar.com.unpaz.gestionfinales.domain.Final;

public class FinalTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 1L;

  private List<Final> snapshots = new ArrayList<>();

  @Override
  public int getRowCount() {
    return snapshots.size();
  }

  @Override
  public int getColumnCount() {
    return FinalColumn.values().length;
  }

  @Override
  public String getColumnName(int column) {
    return FinalColumn.at(column).name;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return FinalColumn.at(columnIndex).valueIn(snapshots.get(rowIndex));
  }

  public void setFinals(List<Final> finals) {
    snapshots = finals;
    fireTableDataChanged();
  }

  public Final getInRow(int rowIndex) {
    return snapshots.get(rowIndex);
  }

}
