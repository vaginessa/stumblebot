package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;
import eecs285.Reblog.Filter;

public class FilterPostsAction implements ActionListener
{
  private static List<Post> filteredPosts = new ArrayList<Post>();

  public void actionPerformed(ActionEvent actionEvent)
  {
    TumblrReblogGUI.getRestoreButton().setEnabled(true);
    TumblrReblogGUI.getPostButton().setEnabled(true);
    App.globalPostsPreFilter = App.globalPosts;
    filteredPosts = Filter.postsToReblog();
    App.globalPosts = filteredPosts;
    Simulator.updatePosts();
  }
}
