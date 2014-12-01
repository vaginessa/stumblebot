package eecs285.Reblog;

import com.tumblr.jumblr.types.Post;
import eecs285.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reblog
{

  public static void ReblogOne(Post post)
  {
    System.out.println(post.toString());
    post.setTags(Filter.tagsFromPost(post));
    long id = post.getId();
    String key = post.getReblogKey();
    String text = "";

    for (String tag : post.getTags()) {
      HashMap<String, ArrayList<String>> map = Filter.tagTextMap;
      if (map.containsKey(tag))
        text.concat(map.get(tag).get(map.get(tag).size() - 1));
    }

    text.concat("Reblog/Like if you agree or somewhat agree!\n");

    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("comment", text);

    try {
      App.client.postReblog(App.blogName, id, key, params);
      //post.reblog(App.blogName);
    }
    catch( NullPointerException e )
    {
      System.out.println("Exception: " + e.getMessage());
    }

    try
    {
      post.like();
    }
    catch( NullPointerException e )
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
