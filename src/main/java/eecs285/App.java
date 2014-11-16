package eecs285;



import java.awt.Dimension;
import java.util.List;

import javax.swing.WindowConstants;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.AnswerPost;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

import eecs285.GUI.TumblrReblogGUI;

/**
 *
 *
 */
public class App 
{
    public static List<String> globalTagsSeeded;
    public static List<String> globalTags;
    public static List<Post> globalPosts;
    public static List<String> globalReblogTexts;
    public static TumblrReblogGUI win;
    public static Blog ourBlog;
    public static JumblrClient client;
    public static void main( String[] args )
    {
      System.out.println( "harhar" );

      // Authenticate via OAuth
      client = new JumblrClient(
              "fP4T709QbfTBOaR4mHLNFeE6BgbwxQw10qSypEN9onlWKGwsBn",
              "bnOedxoYrDveIr6mbg793VLkyhEF8RviaYyFFvuiWpajXZCFsB"
      );
      System.out.println( "harhar" );

      client.setToken(
              "UmFBwJCEgshbDAwKwHbRyfHwxo7k2VO4OI41IOnv1Ouklk3XnE",
              "zpDQUGI0z81X3KeUiDgTLvAeZ6ETBhjepVQsK1hnOJSq6occAz"
      );


      win = new TumblrReblogGUI();
      win.setMinimumSize(new Dimension(400, 400));
      win.pack();
      win.setVisible(true);
      win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      // Make the request
      
      List<Post> list = client.blogPosts("ikimaru.tumblr.com");
      System.out.println(list.size());
      for(Post post : list)
      {
        System.out.println(post.toString());
        if(post.getType().equals("answer"))
        {
          System.out.println(((AnswerPost) post).getQuestion());
          System.out.println(((AnswerPost) post).getAnswer());
        }
        else if(post.getType().equals("audio"))
        {
          
        }
        else if(post.getType().equals("chat"))
        {
          
        }
        else if(post.getType().equals("link"))
        {
          
        }
        else if(post.getType().equals("photo"))
        {
          
        }
        else if(post.getType().equals("quote"))
        {
          
        }
        else if(post.getType().equals("safe"))
        {
          
        }
        else if(post.getType().equals("text"))
        {
          
        }
        else if(post.getType().equals("video"))
        {
          
        }
      }

      System.out.println( "blow" );
    }
    
    
}

/*Startup();
while(1)
{
  updateGlobals();
  Reblog();
  updateGUI();
  if(quit)
  {
    break;
  }
}*/
