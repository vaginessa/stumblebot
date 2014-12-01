package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.Utility.PostMain;

public class StartButtonActionListener implements ActionListener
{
  private static int totalTime = 0;

  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(StartButtonAction.getFrameDialog(),
        "Are you sure this is how long you want between each set of reposts?",
        "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      totalTime += StartButtonAction.getHours() * 60 * 60;
      totalTime += StartButtonAction.getMinutes() * 60;
      totalTime += StartButtonAction.getSeconds();
      PostMain.postMain(totalTime);
      StartButtonAction.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
