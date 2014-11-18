package eecs285;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.WindowConstants;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

import eecs285.GUI.TumblrReblogGUI;

/**
 *
 *
 */
public class App
{
  public static List<String> globalTagsSeeded = new ArrayList<String>();
  public static List<String> globalTagsFound = new ArrayList<String>();
  public static List<Post> globalPosts = new ArrayList<Post>();
  // This is used whenever the user filters all posts. Think of it as a backup.
  public static List<Post> globalPostsPreFilter = new ArrayList<Post>();
  public static List<String> globalReblogTexts;
  public static TumblrReblogGUI win;
  public static Blog ourBlog;
  public static JumblrClient client;

  public static void main(String[] args)
  {
    // Authenticate via OAuth
    client = new JumblrClient(
        "fP4T709QbfTBOaR4mHLNFeE6BgbwxQw10qSypEN9onlWKGwsBn",
        "bnOedxoYrDveIr6mbg793VLkyhEF8RviaYyFFvuiWpajXZCFsB");

    client.setToken("UmFBwJCEgshbDAwKwHbRyfHwxo7k2VO4OI41IOnv1Ouklk3XnE",
        "zpDQUGI0z81X3KeUiDgTLvAeZ6ETBhjepVQsK1hnOJSq6occAz");


    win = new TumblrReblogGUI();
    win.setMinimumSize(new Dimension(802, 670));
    win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
