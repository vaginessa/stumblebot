package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;

public class Reblog
{
  public Reblog()
  {
    List<Post> postsToReblog = Filter.postsToReblog();
    for(Post postIter : postsToReblog)
    {
      System.out.println(postIter.toString());
      postIter.setTags(Filter.tagsFromPost(postIter));
      //postIter.reblog(App.ourBlog.getTitle());
      //App.client.blogInfo(postIter.getBlogName()).follow();
    }
  }
}
