package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.TumblrReblogGUI;

public class StopButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    TumblrReblogGUI.getFetchButton().setEnabled(true);
    TumblrReblogGUI.getFilterButton().setEnabled(true);
    TumblrReblogGUI.getRestoreButton().setEnabled(true);
    TumblrReblogGUI.getPostButton().setEnabled(true);
    TumblrReblogGUI.getStartButton().setEnabled(true);
    TumblrReblogGUI.getStopButton().setEnabled(false);
    TumblrReblogGUI.getTimeButton().setEnabled(false);
  }
}
