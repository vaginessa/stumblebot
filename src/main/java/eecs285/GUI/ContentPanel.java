package eecs285.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ContentPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  Image image = null;

  ContentPanel()
  {
    MediaTracker mt = new MediaTracker(this);
    image = Toolkit.getDefaultToolkit().getImage(
        "src/main/java/images/background.png");
    mt.addImage(image, 0);
    try
    {
      mt.waitForAll();
    }
    catch( InterruptedException e )
    {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int imwidth = image.getWidth(null);
    int imheight = image.getHeight(null);
    g.drawImage(image, 1, 1, null);
  }
}
