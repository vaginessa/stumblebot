package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;
import eecs285.Inputs.FindPosts;


public class FetchPostsAction implements ActionListener
{
  public void actionPerformed(ActionEvent actionEvent)
  {
    TumblrReblogGUI.justFiltered = false;
    List<Post> retrievedPosts = FindPosts.findFrom(App.globalTagsSeeded);
    for( Post test : retrievedPosts )
    {
      System.out.println(test.toString());
      System.out.println(test.getPostUrl());
      App.globalPosts.clear();
      for( Post stringIterCurrent : retrievedPosts )
      {
        if( !App.globalPosts.contains(stringIterCurrent) )
        {
          ((ArrayList<Post>) App.globalPosts).add(stringIterCurrent);
        }
      }
    }
    Simulator.updatePosts();
  }
}
