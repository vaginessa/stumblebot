package eecs285.Utility;

import java.util.List;
import java.util.Random;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.Reblog.Filter;
import eecs285.Reblog.Reblog;

public class Timer
{

  public static long startTime = 0;
  
  /*public static long meanTime = 60000;
  public static long stDevTime = 20000;
  public static long meanTimeBetweenPosts = 1000;
  public static long stDevTimeBetweenPosts = 2000;*/

  public static void start()
  {
    startTime = System.currentTimeMillis();
  }

  public static long getTimeSinceStart()
  {
    return System.currentTimeMillis() - startTime;
  }

  public static long getStartTime()
  {
    return startTime;
  }
  
  /*public static void timeSimulate(int numPostsToReblog)
  {
    Random rand = new Random();
    int timesPosted = 0;
    long downTime = (long) (rand.nextGaussian() * stDevTime + meanTime);
    long waitTime = (long) (rand.nextGaussian() * stDevTimeBetweenPosts + meanTimeBetweenPosts);
    
    if (System.currentTimeMillis() - startTime == downTime
        || System.currentTimeMillis() - startTime == 0)
    {
      //List<Post> postsToReblog = Filter.postsToReblog(App.globalPosts);
      while (timesPosted < numPostsToReblog)
      {
        if (System.currentTimeMillis() - startTime == waitTime
            || System.currentTimeMillis() - startTime == 0)
        {
          Reblog.ReblogOne(postsToReblog.get(timesPosted));
          timesPosted++;
        }      
      }
    }
  }*/

}
