package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;

public class RestorePostsAction implements ActionListener
{
  public void actionPerformed(ActionEvent actionEvent)
  {
    App.globalPosts = App.globalPostsPreFilter;
    Simulator.updatePosts();
    TumblrReblogGUI.getRestoreButton().setEnabled(false);
  }
}
