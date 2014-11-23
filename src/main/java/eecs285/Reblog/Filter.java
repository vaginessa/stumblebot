package eecs285.Reblog;

import com.tumblr.jumblr.types.Post;
import eecs285.App;

import java.util.List;

// Yogesh <-
public class Filter
{
  public static List<Post> postsToReblog()
  {
    long noteCount = 0;
    for (Post post : App.globalPosts)
    {
      
    }
    return App.globalPosts;
  }
  
  static List<String> tagsFromPost(Post inPost)
  {
    return inPost.getTags();
  }

  static String textForPost(Post inPost)
  {
    return "";
  }
  
  static String titleForPost(Post inPost)
  {
    return inPost.getBlogName();
  }
}
