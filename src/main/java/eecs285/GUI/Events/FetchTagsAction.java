package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.tumblr.jumblr.types.Post;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.Inputs.FindTags;


public class FetchTagsAction implements ActionListener
{
  public void actionPerformed(ActionEvent actionEvent)
  {
    List<String> retrievedTags = FindTags.findFrom(App.globalPosts);
    App.globalTagsFound.clear();
    for(String stringIterCurrent : retrievedTags )
    {
      if( !App.globalTagsFound.contains(stringIterCurrent) && !App.globalTagsSeeded.contains(stringIterCurrent))
      {
        App.globalTagsFound.add(stringIterCurrent);
        System.out.println(stringIterCurrent);
      }
    }
    Simulator.updateTags();
  }
}
