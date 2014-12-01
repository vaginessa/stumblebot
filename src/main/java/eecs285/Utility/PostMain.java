package eecs285.Utility;

import java.util.Date;
import java.util.Timer;

public class PostMain
{
  static Timer time;
  static PostTask pt;
  static Date startDate = new Date();

  public static void postMain(int timeBetweenPosts)
  {
    time = new Timer();
    pt = new PostTask();
    time.schedule(pt, 0, timeBetweenPosts * 1000);
  }

  public static void stopTimer()
  {
    time.cancel();
    time.purge();
  }

  public static long getTime()
  {
    return new Date().getTime() - startDate.getTime();
  }
}
