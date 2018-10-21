package ar.com.unpaz.gestionfinales.console.subjects;

import java.util.ArrayList;
import java.util.List;
import ar.com.unpaz.gestionfinales.console.ConsoleWriter;
import ar.com.unpaz.gestionfinales.domain.Subject;
import ar.com.unpaz.gestionfinales.presentation.subjects.SubjectColumn;

public class SubjectTableConsole {

  private List<Subject> subjects;
  private ConsoleWriter writer;
  
  public SubjectTableConsole() {
    subjects = new ArrayList<>();
    writer = new ConsoleWriter();
  }
  
  public void updateList(List<Subject> subjects) {
    this.subjects = subjects;
  }
  
  public void print() {
    printHeader();
    printRows();
  }
  
  private void printHeader() {
    for(SubjectColumn col :SubjectColumn.values()) {
      writer.print(col.name+"  ");
    }
  }
  
  private void printRows() {
    for(Subject subject : subjects) {
      printRow(subject);
    }
  }
  
  private void printRow(Subject subject) {
    for(SubjectColumn colum : SubjectColumn.values()) {
      writer.print(colum.valueIn(subject) +"  ");
    }
    writer.println();
  }

  public Subject getInRow(int rowIndex) {
    return subjects.get(rowIndex);
  }
 
}
