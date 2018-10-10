package ar.com.unpaz.gestionfinales.presentation.view.swing.util;

import static java.lang.String.valueOf;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconResource {

  private IconResource() {
    throw new AssertionError();
  }

  public static Icon load(IconPathOf path) {
    return new ImageIcon(IconResource.class.getClass().getResource(valueOf(path)));
  }

  public static enum IconPathOf {

    ICON("/images/icon.png"),
    
    BACKGROUND("/images/background.png"),

    ADD("/images/add.png"),

    UPDATE("/images/update.png"),

    DELETE("/images/delete.png"),

    SAVE("/images/save.png") ,
    
    CANCEL("/images/cancel.png");
    
    private String path;

    private IconPathOf(String path) {
      this.path = path;
    }

    @Override
    public String toString() {
      return path;
    }

  }

}
