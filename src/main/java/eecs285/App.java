package eecs285;


import java.awt.Desktop;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TumblrApi;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

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
  public static OAuthService service;
  private static String authentication;

  /* Constants */
  private static final String CONSUMER_KEY = "fP4T709QbfTBOaR4mHLNFeE6BgbwxQw10qSypEN9onlWKGwsBn";
  private static final String CONSUMER_SECRET = "bnOedxoYrDveIr6mbg793VLkyhEF8RviaYyFFvuiWpajXZCFsB";

  public static String blogName = "letitkorra.tumblr.com";

  // Desktop Stuff
  private static Desktop userDesktop = Desktop.getDesktop();

  public static void main(String[] args)
  {
    boolean goodEntry = false;
    service = new ServiceBuilder().provider(TumblrApi.class)
        .apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET)
        .callback("http://localhost:8080/").build();

    System.out.println("=== Tumblr's OAuth Workflow ===");
    System.out.println();
    // Obtain the Request Token
    System.out.println("Fetching the Request Token...");
    Token requestToken = service.getRequestToken();
    System.out.println("Got the Request Token!");
    System.out.println();
    System.out.println("Now go and authorize Scribe here:");
    System.out.println(service.getAuthorizationUrl(requestToken));
    try
    {
      userDesktop.browse(new URI(service.getAuthorizationUrl(requestToken)));
    }
    catch( IOException | URISyntaxException event )
    {
      event.printStackTrace();
    }
    while( !goodEntry )
    {
      authentication = (String) JOptionPane
          .showInputDialog(
              App.win,
              "Please log into Tumblr and "
                  + "allow stumblr to access data in your account.\n"
                  + "Once you see a page with \"Access Error: 404 -- Not Found\", "
                  + "copy the URL beginning with \"localhost\" into the box below\n"
                  + "For Example, \"http://localhost:8080/?oauth_token"
                  + "=XXXXX&oauth_verifier=XXXXX#_=_\"\n"
                  + "Enter nothing and press Cancel to exit the program.",
              "Enter Authentication Here", JOptionPane.PLAIN_MESSAGE);
      if( authentication == null )
      {
        if( JOptionPane.showConfirmDialog(App.win,
            "You did not enter a code. Do you want to try again?",
            "Incorrect Authentication", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION )
        {
          System.exit(0);
        }
      }
      // If a string was returned, say so.
      if( (authentication != null) && (authentication.length() > 0) )
      {
        try
        {
          if( !authentication.contains("&oauth_verifier=") )
          {
            throw new OAuthException(authentication);
          }
          String[] splitVerify = authentication.split("&oauth_verifier=");
          splitVerify = splitVerify[1].split("#_=_");
          authentication = splitVerify[0];
          System.out.println("Code: " + authentication);
          Verifier verifier = new Verifier(authentication);
          System.out.println();
          System.out
              .println("Trading the Request Token for an Access Token...");
          Token accessToken = service.getAccessToken(requestToken, verifier);
          System.out.println("Got the Access Token!");
          System.out.println("(if your curious it looks like this: "
              + accessToken + " )");
          System.out.println();
          client = new JumblrClient(CONSUMER_KEY, CONSUMER_SECRET);
          client.setToken(accessToken.getToken(), accessToken.getSecret());
          goodEntry = true;
        }
        catch( OAuthException event )
        {
          JOptionPane.showMessageDialog(App.win,
              "Your authentication code was incorrect. Try again.",
              "Incorrect Authentication", JOptionPane.WARNING_MESSAGE);
        }
        catch( ArrayIndexOutOfBoundsException event )
        {
          JOptionPane.showMessageDialog(App.win,
              "Your authentication code was incorrect. Try again.",
              "Incorrect Authentication", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
    /*
     * System.out.println("And paste the verifier here");
     * System.out.print(">>"); String inVerify = in.nextLine();
     * System.out.println("inVerify: " + inVerify); String[] splitVerify =
     * inVerify.split("&oauth_verifier="); splitVerify =
     * splitVerify[1].split("#_=_"); inVerify = splitVerify[0];
     * System.out.println("Code: " + inVerify);
     */


    // Trade the Request Token and Verifier for the Access Token


    // User user = client.user();
    // System.out.println(user);
    // OAuthRequest request = new OAuthRequest( Verb.POST,
    // "api.tumblr.com/v2/blog//post/reblog");
    // service.signRequest( accessToken, request );

    // ourBlog = client.blogInfo(blogName);
    // System.out.println(ourBlog.getName());

    win = new TumblrReblogGUI();
    win.setMinimumSize(new Dimension(802, 670));
    win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}

// private static final String PROTECTED_RESOURCE_URL =
// "http://api.tumblr.com/v2/user/info";

/*
 * // Now let's go and ask for a protected resource! System.out.println(
 * "Now we're going to access a protected resource..." ); OAuthRequest request =
 * new OAuthRequest( Verb.GET , PROTECTED_RESOURCE_URL ); service.signRequest(
 * accessToken , request ); Response response = request.send();
 * System.out.println( "Got it! Lets see what we found..." );
 * System.out.println(); System.out.println( response.getBody() );
 */
/*
 * // Authenticate via OAuth client = new JumblrClient(
 * "fP4T709QbfTBOaR4mHLNFeE6BgbwxQw10qSypEN9onlWKGwsBn",
 * "bnOedxoYrDveIr6mbg793VLkyhEF8RviaYyFFvuiWpajXZCFsB");
 * 
 * client.setToken("UmFBwJCEgshbDAwKwHbRyfHwxo7k2VO4OI41IOnv1Ouklk3XnE",
 * "zpDQUGI0z81X3KeUiDgTLvAeZ6ETBhjepVQsK1hnOJSq6occAz");
 */
