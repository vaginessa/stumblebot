package eecs285.Utility;

import java.util.Date;
import java.util.TimerTask;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.Events.FetchPostsAction;
import eecs285.GUI.Events.FilterPostsAction;
import eecs285.Reblog.Reblog;

public class PostTask extends TimerTask
{
  static Date now;
  private static int totalTimes = 0;

  public void run()
  {
    now = new Date();
    System.out.println("Time is: " + now); // Replace this with actual stuff
    App.globalPosts.clear();
    App.globalPostsPreFilter.clear();
    FetchPostsAction fetchNewPosts = new FetchPostsAction();
    fetchNewPosts.actionPerformed(null);
    Simulator.updatePosts();
    System.out.println("Fetched new posts! " + totalTimes);
    FilterPostsAction filterPosts = new FilterPostsAction();
    filterPosts.actionPerformed(null);
    Simulator.updatePosts();
    System.out.println("Filtered new posts! " + totalTimes);
    Reblog.ReblogAll();
    /*
     * App.globalPostsPreFilter = FindPosts.findFrom(App.globalTagsSeeded);
     * App.globalPosts = App.globalPostsPreFilter; Simulator.updatePosts();
     * App.globalPosts = Filter.postsToReblog(App.globalPostsPreFilter);
     * System.out.println("Fetched new posts! " + totalTimes);
     * Reblog.ReblogAll(); System.out.println("Filtered new posts! " +
     * totalTimes); Simulator.updatePosts();
     */
    totalTimes++;

    // PostButtonAction repostPosts = new PostButtonAction();
    // repostPosts.actionPerformed(null);
  }

}
