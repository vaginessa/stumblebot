package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

public class Reblog
{
  
  public static void ReblogOne(Post post)
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
  
  
  public static void ReblogAll()
  {
    List<Post> postsToReblog = App.globalPosts;
    for( Post post : postsToReblog )
    {
      ReblogOne(post);
    }
  }
}
