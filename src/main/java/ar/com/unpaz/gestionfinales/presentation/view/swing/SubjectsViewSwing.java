package ar.com.unpaz.gestionfinales.presentation.view.swing;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import ar.com.unpaz.gestionfinales.domain.Year;
import ar.com.unpaz.gestionfinales.presentation.view.SubjectView;

public class SubjectsViewSwing implements SubjectView {

  private JTable tableSubjects;
  private JComboBox<Year> comboxYear;
  private JButton buttonAdd;
  private JButton buttonUpdate;
  private JButton buttonDelete;
  
  public SubjectsViewSwing() {
    
  }

  @Override
  public void show() {
   System.out.println("SubjectViewSwing.show");
  }
  
}
