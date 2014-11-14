package eecs285;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      // Authenticate via OAuth
      JumblrClient client = new JumblrClient(
              "fP4T709QbfTBOaR4mHLNFeE6BgbwxQw10qSypEN9onlWKGwsBn",
              "bnOedxoYrDveIr6mbg793VLkyhEF8RviaYyFFvuiWpajXZCFsB"
      );
      System.out.println( "heheh" );

      client.setToken(
              "UmFBwJCEgshbDAwKwHbRyfHwxo7k2VO4OI41IOnv1Ouklk3XnE",
              "zpDQUGI0z81X3KeUiDgTLvAeZ6ETBhjepVQsK1hnOJSq6occAz"
      );


      // Make the request
      Blog blog = client.blogInfo("delicatedragonstarlight.tumblr.com");

      System.out.println( blog.getName() );

      System.out.println( "heheh" );
    }
}
