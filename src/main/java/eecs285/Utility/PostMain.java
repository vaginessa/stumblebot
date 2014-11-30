package eecs285.Utility;

import java.util.Timer;

public class PostMain
{
  public static void postMain()
  {
    Timer time = new Timer();
    PostTask pt = new PostTask();
    time.schedule(pt, 0, 3000);
  }
}
