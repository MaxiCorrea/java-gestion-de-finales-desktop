package ar.com.unpaz.gestionfinales.swing.subjects;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.SimpleSubjectColumn;

public class SimpleSubjectTableModelSwing extends AbstractTableModel {

  private static final long serialVersionUID = 1L;
  private List<Subject> snapshots = new ArrayList<>();

  @Override
  public int getRowCount() {
    return snapshots.size();
  }

  @Override
  public String getColumnName(int column) {
    return SimpleSubjectColumn.at(column).name;
  }

  @Override
  public int getColumnCount() {
    return SimpleSubjectColumn.values().length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return SimpleSubjectColumn.at(columnIndex).valueIn(snapshots.get(rowIndex));
  }

  public void setSubjects(List<Subject> subject) {
    snapshots = subject;
    fireTableDataChanged();
  }

  public Subject getInRow(int rowIndex) {
    return snapshots.get(rowIndex);
  }

}
