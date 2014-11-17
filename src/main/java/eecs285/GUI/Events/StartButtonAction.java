package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.TumblrReblogGUI;

public class StartButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    TumblrReblogGUI.getStartButton().setEnabled(false);
    TumblrReblogGUI.getStopButton().setEnabled(true);
  }
}