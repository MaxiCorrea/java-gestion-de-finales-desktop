package ar.com.unpaz.gestionfinales.presentation.view.swing;

import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.load;
import static ar.com.unpaz.gestionfinales.presentation.view.swing.util.IconResource.IconPathOf.BACKGROUND;
import static java.awt.BorderLayout.CENTER;
import static java.awt.event.InputEvent.CTRL_MASK;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_M;
import static java.awt.event.KeyEvent.VK_S;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.KeyStroke.getKeyStroke;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.presentation.view.AppPresentationContext;

public class AppViewSwing {

  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu menuItemAMB;
  private JMenuItem menuItemSubjects;
  private JMenuItem menuItemStudents;
  private JMenuItem menuItemFinals;
  private JMenu menuItemSystem;
  private JMenuItem menuItemAbout;
  private JMenuItem menuItemExit;

  public AppViewSwing() {
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
      AppPresentationContext.subjectView.show();
    });
    menuItemSubjects.setAccelerator(getKeyStroke(VK_M, CTRL_MASK));
    menuItemAMB.add(menuItemSubjects);
    menuItemStudents = new JMenuItem("Alumnos");
    menuItemStudents.addActionListener((ActionEvent e) -> {
      AppPresentationContext.studentView.show();
    });
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
    menuItemExit.addActionListener((ActionEvent e) -> {

    });
    menuItemExit.setAccelerator(getKeyStroke(VK_S, CTRL_MASK));
    menuItemSystem.add(menuItemExit);
    frame.getContentPane().add(new JPanel() {
      private static final long serialVersionUID = 1L;

      @Override
      public void paint(Graphics g) {
        g.drawImage(((ImageIcon) load(BACKGROUND)).getImage(), 0, 0, getWidth(), getHeight(), this);
      }
    }, CENTER);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

}
