package eecs285.Utility;

public class Timer {

  public static long startTime = 0;
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

}