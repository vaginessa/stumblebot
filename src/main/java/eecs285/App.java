package eecs285;

import com.tumblr.jumblr.JumblrClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      JumblrClient client = new JumblrClient("consumer_key", "consumer_secret");
      client.setToken("oauth_token", "oauth_token_secret");

      System.out.println( "Hello World!" );
    }
}
