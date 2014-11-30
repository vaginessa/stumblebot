package eecs285.Reblog;

import com.tumblr.jumblr.types.Post;
import eecs285.App;
import eecs285.GUI.Simulator;

import java.util.List;

public class Reblog
{
  public Reblog()
  {
    List<Post> postsToReblog = Filter.postsToReblog(App.globalPosts);
    for( Post post : postsToReblog )
    {
      System.out.println(post.toString());
      post.setTags(Filter.tagsFromPost(post));
      try {
        post.reblog(App.blogName);
      }
      catch (NullPointerException e)
      {
        System.out.println("Exception: " + e.getMessage());
      }

      try {
        post.like();
      }
      catch (NullPointerException e)
      {
        System.out.println("Exception: " + e.getMessage());
      }

      App.client.blogInfo(post.getBlogName()).follow();
    }
    postsToReblog = Filter.postsToReblog(App.globalPosts);
    App.globalPosts = postsToReblog;
    Simulator.updatePosts();
  }
}
