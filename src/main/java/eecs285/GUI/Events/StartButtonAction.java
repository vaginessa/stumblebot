package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.TumblrReblogGUI;
import eecs285.Utility.Timer;

public class StartButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    Timer.start();
    TumblrReblogGUI.getFetchButton().setEnabled(false);
    TumblrReblogGUI.getFilterButton().setEnabled(false);
    TumblrReblogGUI.getRestoreButton().setEnabled(false);
    TumblrReblogGUI.getPostButton().setEnabled(false);
    TumblrReblogGUI.getStartButton().setEnabled(false);
    TumblrReblogGUI.getStopButton().setEnabled(true);
    TumblrReblogGUI.getTimeButton().setEnabled(true);
  }
}
