package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.GUI.Simulator;

public class Reblog
{
  public Reblog()
  {
    List<Post> postsToReblog = Filter.postsToReblog(App.globalPosts);
    for( Post postIter : postsToReblog )
    {
      System.out.println(postIter.toString());
      postIter.setTags(Filter.tagsFromPost(postIter));
      // postIter.reblog(App.ourBlog.getTitle());
      // App.client.blogInfo(postIter.getBlogName()).follow();
    }
    postsToReblog = Filter.postsToReblog(App.globalPosts);
    App.globalPosts = postsToReblog;
    Simulator.updatePosts();
  }
}
