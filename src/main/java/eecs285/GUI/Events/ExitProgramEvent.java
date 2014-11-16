package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.GUI.TumblrReblogGUI;

// Handles the event of exiting the program
public class ExitProgramEvent implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if(TumblrReblogGUI.saved)
    {
      System.exit(0);
    }
    else
    {
      if( JOptionPane.showConfirmDialog(App.win,
          "Are you sure that you want to exit the program without saving?", 
          "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
      {
        System.exit(0);
      }
      else
      {
        return;
      }
    }
  }
}
