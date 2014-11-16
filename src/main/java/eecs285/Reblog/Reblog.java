package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

public class Reblog
{
  public Reblog()
  {
    List<Post> postsToReblog = Filter.postsToReblog(App.globalPosts);
    for(Post post : postsToReblog)
    {
      post.setTags(Filter.tagsFromPost(post));
      post.reblog(Filter.titleForPost(post));
    }
  }
}
