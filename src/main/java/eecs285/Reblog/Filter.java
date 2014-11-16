package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.*;

import eecs285.App;

public class Filter
{
  static List<Post> postsToReblog(List<Post> inPosts)
  {
    return App.globalPosts;
  }
  
  static List<String> tagsFromPost(Post inPost)
  {
    return inPost.getTags();
  }
  
  static String titleForPost(Post inPost)
  {
    return inPost.getBlogName() + " Repost";
  }
}
