package ar.com.unpaz.gestionfinales.swing;

import static ar.com.unpaz.gestionfinales.swing.IconResource.load;
import static ar.com.unpaz.gestionfinales.swing.IconResource.IconPathOf.GITHUB;
import static ar.com.unpaz.gestionfinales.swing.IconResource.IconPathOf.LINKEDIN;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ar.com.unpaz.gestionfinales.presentation.AboutDialog;
import ar.com.unpaz.gestionfinales.swing.IconResource.IconPathOf;

public class AboutDialogSwing implements AboutDialog {
  
  private JDialog dialog;

  public AboutDialogSwing() {
    dialog = new JDialog();
    dialog.setModal(true);
    dialog.setTitle(TITLE);
    dialog.setSize(220, 180);
    dialog.setResizable(false);
    dialog.getContentPane().add(createCenterPane(), CENTER);
    dialog.getContentPane().add(createSouthPane(), SOUTH);
  }

  private JPanel createCenterPane() {
    JPanel pane = new JPanel();
    pane.setBackground(WHITE);
    pane.add(createLabel(INFORMATION));
    pane.add(createLabel(" "));
    pane.add(createLabel(DEVELOPER));
    pane.add(createLabel(" "));
    pane.add(createLabel(EMAIL));
    pane.add(createLabel(" "));
    pane.add(createLabel(YEAR));
    return pane;
  }

  private JLabel createLabel(String text) {
    JLabel label = new JLabel(text);
    label.setForeground(BLUE);
    return label;
  }
  
  private JPanel createSouthPane() {
    JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 2));
    pane.setBackground(WHITE);
    pane.add(createButtonAndEvent(GITHUB, GITHUB_PAGE));
    pane.add(createButtonAndEvent(LINKEDIN, LINKEDIN_PAGE));
    return pane;
  }

  private JButton createButtonAndEvent(IconPathOf path, String uri) {
    JButton button = new JButton(load(path));
    button.setPreferredSize(new Dimension(40, 40));
    button.setBackground(WHITE);
    button.addActionListener((e) -> {
      openURI(uri);
    });
    return button;
  }

  private void openURI(String uri) {
    Desktop desktop = Desktop.getDesktop();
    try {
      desktop.browse(new URI(uri));
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public void show() {
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }

}
