package eecs285.Utility;

import java.util.TimerTask;
import java.util.Date;

public class PostTask extends TimerTask
{
  Date now;
  
  public void run()
  {
    now = new Date();
    System.out.println("Time is: " + now);
  }
  
}
