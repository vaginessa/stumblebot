package eecs285.Reblog;

import java.util.List;

import com.tumblr.jumblr.types.*;

import eecs285.App;

public class Reblog
{
  public Reblog()
  {
    List<Post> poststoReblog = Filter.postsToReblog(App.globalPosts);
    for(Post post : poststoReblog)
    {
    }
  }
}
