package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.TumblrReblogGUI;
import eecs285.Utility.PostMain;

public class StartButtonAction implements ActionListener
{
  public static int numPosts = 5;
  
  public void actionPerformed(ActionEvent event)
  {
    PostMain.postMain();
    
    TumblrReblogGUI.getFetchButton().setEnabled(false);
    TumblrReblogGUI.getFilterButton().setEnabled(false);
    TumblrReblogGUI.getRestoreButton().setEnabled(false);
    TumblrReblogGUI.getPostButton().setEnabled(false);
    TumblrReblogGUI.getStartButton().setEnabled(false);
    TumblrReblogGUI.getStopButton().setEnabled(true);
    TumblrReblogGUI.getTimeButton().setEnabled(true);
  }
}
