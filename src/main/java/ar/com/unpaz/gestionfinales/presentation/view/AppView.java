package ar.com.unpaz.gestionfinales.presentation.view;

import static java.awt.event.InputEvent.CTRL_MASK;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_M;
import static java.awt.event.KeyEvent.VK_S;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.KeyStroke.getKeyStroke;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppView {

  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu menuItemAMB;
  private JMenuItem menuItemSubjects;
  private JMenuItem menuItemStudents;
  private JMenuItem menuItemFinals;
  private JMenu menuItemSystem;
  private JMenuItem menuItemAbout;
  private JMenuItem menuItemExit;

  public AppView() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 600);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setTitle("Sistema de Gestión de Finales");
    menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    menuItemAMB = new JMenu("ABM");
    menuItemAMB.setMnemonic('A');
    menuItemAMB.setMnemonic(VK_A);
    menuBar.add(menuItemAMB);
    menuItemSubjects = new JMenuItem("Materias");
    menuItemSubjects.addActionListener((ActionEvent e) -> {

    });
    menuItemSubjects.setAccelerator(getKeyStroke(VK_M, CTRL_MASK));
    menuItemAMB.add(menuItemSubjects);
    menuItemStudents = new JMenuItem("Alumnos");
    menuItemStudents.setAccelerator(getKeyStroke(VK_A, CTRL_MASK));
    menuItemAMB.add(menuItemStudents);
    menuItemFinals = new JMenuItem("Finales");
    menuItemFinals.setAccelerator(getKeyStroke(VK_F, CTRL_MASK));
    menuItemAMB.add(menuItemFinals);
    menuItemSystem = new JMenu("Sistema");
    menuItemSystem.setMnemonic('S');
    menuItemSystem.setMnemonic(VK_S);
    menuBar.add(menuItemSystem);
    menuItemAbout = new JMenuItem("Acerca de");
    menuItemSystem.add(menuItemAbout);
    menuItemExit = new JMenuItem("Salir de Sistema");
    menuItemExit.addActionListener((ActionEvent e) ->{
      
    });
    menuItemExit.setAccelerator(getKeyStroke(VK_S, CTRL_MASK));
    menuItemSystem.add(menuItemExit);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

}
