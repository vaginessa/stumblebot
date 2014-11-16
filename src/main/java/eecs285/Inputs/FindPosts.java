package eecs285.Inputs;

import java.util.List;
import java.util.Vector;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

//Handles all acquisition of new Posts
public class FindPosts
{
  // gets the first 10 posts relevant to each of the tags
  public static List<Post> findFrom(List<String> inTags)
  {
    List<Post> allPosts = new Vector<Post>();
    List<Post> currentPosts = new Vector<Post>();
    for(String stringIter : inTags)
    {
      currentPosts = App.client.tagged(stringIter);
      for(Post stringIterCurrent : currentPosts)
      {
        if(!allPosts.contains(stringIterCurrent))
        {
          ((Vector<Post>) allPosts).addElement(stringIterCurrent);
        }
      }
    }
    return allPosts;
  }
};
