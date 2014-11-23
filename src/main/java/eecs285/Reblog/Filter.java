package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

// Yogesh <-
public class Filter
{
  public static List<Post> postsToReblog()
  {
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
