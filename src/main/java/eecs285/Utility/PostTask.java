package eecs285.Utility;

import java.util.Date;
import java.util.TimerTask;

import eecs285.GUI.Simulator;
import eecs285.GUI.Events.FetchPostsAction;
import eecs285.GUI.Events.FilterPostsAction;

public class PostTask extends TimerTask
{
  static Date now;
  private static int totalTimes = 0;

  public void run()
  {
    now = new Date();
    System.out.println("Time is: " + now); // Replace this with actual stuff
    FetchPostsAction fetchNewPosts = new FetchPostsAction();
    fetchNewPosts.actionPerformed(null);
    Simulator.updatePosts();
    System.out.println("Fetched new posts! " + totalTimes);
    FilterPostsAction filterPosts = new FilterPostsAction();
    filterPosts.actionPerformed(null);
    Simulator.updatePosts();
    System.out.println("Filtered new posts! " + totalTimes);
    totalTimes++;

    // PostButtonAction repostPosts = new PostButtonAction();
    // repostPosts.actionPerformed(null);
  }

}
