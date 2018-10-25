package ar.com.unpaz.gestionfinales.swing.students;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ar.com.unpaz.gestionfinales.domain.Student;
import ar.com.unpaz.gestionfinales.presentation.students.CompleteStudentColumn;

public class StudentTableModelSwing extends AbstractTableModel {

  private static final long serialVersionUID = 1L;
  private List<Student> snapshots = new ArrayList<>();

  @Override
  public int getColumnCount() {
    return CompleteStudentColumn.values().length;
  }

  @Override
  public int getRowCount() {
    return snapshots.size();
  }

  @Override
  public String getColumnName(int column) {
    return CompleteStudentColumn.at(column).name;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return CompleteStudentColumn.at(columnIndex).valueIn(snapshots.get(rowIndex));
  }

  public void setStudents(List<Student> students) {
    snapshots = students;
    fireTableDataChanged();
  }

  public Student getInRow(int rowIndex) {
    return snapshots.get(rowIndex);
  }

}
