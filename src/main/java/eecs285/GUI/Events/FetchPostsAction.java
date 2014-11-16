package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.Inputs.FindPosts;


public class FetchPostsAction implements ActionListener
{
  public void actionPerformed(ActionEvent actionEvent)
  {
    List<Post> retrievedPosts = FindPosts.findFrom(App.globalTagsSeeded);
  }
}
