package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.JumblrClient;

import eecs285.App;

public class Reblog
{
  public Reblog()
  {
    List<Post> postsToReblog = Filter.postsToReblog(App.globalPosts);
    for(Post post : postsToReblog)
    {
      post.setTags(Filter.tagsFromPost(post));
      post.reblog(App.ourBlog.getTitle());
      App.client.blogInfo(post.getBlogName()).follow();
    }
  }
}
