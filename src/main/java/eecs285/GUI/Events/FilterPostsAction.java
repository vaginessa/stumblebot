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
    if(TumblrReblogGUI.original)
    {
      App.globalPostsPreFilter = App.globalPosts;
      TumblrReblogGUI.original = false;
    }

    filteredPosts = Filter.postsToReblog(App.globalPosts);
    App.globalPosts = filteredPosts;
    Simulator.updatePosts();
    /*
     * Reblog Test
     * 
     * Post test = filteredPosts.get(5);
     * 
     * test.reblog("delicatedragonstarlight.tumblr.com"); String reblogKey =
     * test.getReblogKey(); long postId = test.getId();
     * 
     * //Blog b = App.client.blogInfo("delicatedragonstarlight"); //List<Post>
     * posts = App.client.blogPosts("delicatedragonstarlight");
     * 
     * //System.out.println(posts.get(0));
     * //posts.get(0).reblog("delicatedragonstarlight.tumblr.com");
     * 
     * 
     * //Post rebloggedPost =
     * App.client.postReblog("delicatedragonstarlight.tumblr.com", postId,
     * reblogKey);
     */
  }
}
