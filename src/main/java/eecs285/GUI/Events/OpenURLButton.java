package eecs285.GUI.Events;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;

import com.tumblr.jumblr.types.Post;

// Creates a common button that closes a window upon being pressed
public class OpenURLButton extends JButton implements ActionListener
{
  private static Desktop userDesktop = Desktop.getDesktop();
  private static Post selectedPost;
  private static final long serialVersionUID = 1L;

  public OpenURLButton(Post inPost)
  {
    super("Open in Browser");
    selectedPost = inPost;
    addActionListener(this);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event)
  {
    try
    {
      userDesktop.browse(new URI(selectedPost.getPostUrl()));
    }
    catch( IOException | URISyntaxException event1 )
    {
      event1.printStackTrace();
    }
  }
}
