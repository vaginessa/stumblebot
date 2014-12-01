package eecs285.Utility;

import java.util.TimerTask;
import java.util.Date;

public class PostTask extends TimerTask
{
  static Date now;
  
  public void run()
  {
    now = new Date();
    System.out.println("Time is: " + now); //Replace this with actual stuff
  }
  
}
