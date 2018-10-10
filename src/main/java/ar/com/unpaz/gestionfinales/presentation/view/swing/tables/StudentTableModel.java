package ar.com.unpaz.gestionfinales.presentation.view.swing.tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.model.StudentColumn;

public class StudentTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 1L;
  private List<Student> snapshots = new ArrayList<>();

  @Override
  public int getColumnCount() {
    return StudentColumn.values().length;
  }

  @Override
  public int getRowCount() {
    return snapshots.size();
  }

  @Override
  public String getColumnName(int column) {
    return StudentColumn.at(column).name;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return StudentColumn.at(columnIndex).valueIn(snapshots.get(rowIndex));
  }

  public void setStudents(List<Student> students) {
    snapshots = students;
    fireTableDataChanged();
  }

  public Student getInRow(int rowIndex) {
    return snapshots.get(rowIndex);
  }

}
