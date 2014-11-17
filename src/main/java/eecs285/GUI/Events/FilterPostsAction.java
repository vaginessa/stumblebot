package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;

public class FilterPostsAction implements ActionListener
{
  private static List<Post> filteredPosts = new Vector<Post>();

  public void actionPerformed(ActionEvent actionEvent)
  {
    TumblrReblogGUI.getRestoreButton().setEnabled(true);
    App.globalPostsPreFilter = App.globalPosts;
    // TODO Call reblog function here
    App.globalPosts = filteredPosts;
    Simulator.updatePosts();
  }
}
