package eecs285.Utility;

import java.util.Timer;
import java.util.Date;

public class PostMain
{
  static Timer time;
  static PostTask pt;
  static Date startDate = new Date();
  static int secondsBetweenPosts = 3;
  
  public static void postMain()
  {
    time = new Timer();
    pt = new PostTask();
    time.schedule(pt, 0, secondsBetweenPosts*1000);
  }
  
  public static void stopTimer()
  {
    time.cancel();
  }
  
  public static long getTime()
  {
    return PostTask.now.getTime() - startDate.getTime();
  }
}
