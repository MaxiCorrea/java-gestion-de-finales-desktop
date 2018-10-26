package ar.com.unpaz.gestionfinales.swing;

import static ar.com.unpaz.gestionfinales.swing.IconResource.load;
import static ar.com.unpaz.gestionfinales.swing.IconResource.IconPathOf.BACKGROUND;
import static java.awt.BorderLayout.CENTER;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.awt.event.InputEvent.CTRL_MASK;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_M;
import static java.awt.event.KeyEvent.VK_S;
import static java.lang.String.valueOf;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.KeyStroke.getKeyStroke;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.presentation.AppView;
import ar.com.unpaz.gestionfinales.usecase.AppControllerContext;

public class AppViewSwing implements AppView {

  private static final int HEIGHT_FRAME = 550;
  private static final int WITH_FRAME = 900;
  private static final String TITLE = "Sistema de Gestión de Finales";
  private JFrame frame;

  public AppViewSwing() {
    frame = new JFrame();
    frame.setIconImage(getDefaultToolkit()
        .getImage(getClass().getResource(valueOf(IconResource.IconPathOf.ICON))));
    frame.setSize(WITH_FRAME, HEIGHT_FRAME);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setTitle(TITLE);
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu menuItemAMB = new JMenu("ABM");
    menuItemAMB.setMnemonic('A');
    menuItemAMB.setMnemonic(VK_A);
    menuBar.add(menuItemAMB);
    JMenuItem menuItemSubjects = new JMenuItem("Materias");
    menuItemSubjects.setAccelerator(getKeyStroke(VK_M, CTRL_MASK));
    menuItemAMB.add(menuItemSubjects);
    JMenuItem menuItemStudents = new JMenuItem("Alumnos");
    menuItemStudents.setAccelerator(getKeyStroke(VK_A, CTRL_MASK));
    menuItemAMB.add(menuItemStudents);
    JMenuItem menuItemFinals = new JMenuItem("Finales");
    menuItemFinals.setAccelerator(getKeyStroke(VK_F, CTRL_MASK));
    menuItemAMB.add(menuItemFinals);
    JMenuItem menuItemSystem = new JMenu("Sistema");
    menuItemSystem.setMnemonic('S');
    menuItemSystem.setMnemonic(VK_S);
    menuBar.add(menuItemSystem);
    JMenuItem menuItemAbout = new JMenuItem("Acerca de");
    menuItemSystem.add(menuItemAbout);
    JMenuItem menuItemExit = new JMenuItem("Salir de Sistema");
    menuItemExit.setAccelerator(getKeyStroke(VK_S, CTRL_MASK));
    menuItemSystem.add(menuItemExit);
    frame.getContentPane().add(new JPanel() {
      private static final long serialVersionUID = 1L;

      @Override
      public void paint(Graphics g) {
        g.drawImage(((ImageIcon) load(BACKGROUND)).getImage(), 0, 0, 
            getWidth(), getHeight(), this);
      }
    }, CENTER);

    menuItemSubjects.addActionListener((e) -> {
      AppControllerContext.appController.selectedSubjects();
    });
    menuItemStudents.addActionListener((e) -> {
      AppControllerContext.appController.selectedStudents();
    });
    menuItemFinals.addActionListener((e) -> {
      AppControllerContext.appController.selectedFinals();
    });
    menuItemAbout.addActionListener((e) -> {
      AppControllerContext.appController.selectedAbout();
    });
    menuItemExit.addActionListener((e) -> {
      AppControllerContext.appController.closeApp();
    });

  }

  @Override
  public void show() {
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  @Override
  public void close() {
    frame.setVisible(false);
    frame.dispose();
  }

  @Override
  public void showError(String message) {
    JOptionPane.showMessageDialog(frame, message);
  }

}
