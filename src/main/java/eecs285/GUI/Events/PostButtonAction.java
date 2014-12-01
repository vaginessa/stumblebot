package eecs285.GUI.Events;

import eecs285.App;
import eecs285.Reblog.Reblog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yogesh on 11/16/14.
 */
public class PostButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(App.win, "Are you sure you want to repost all " + App.globalPosts.size() + " post(s)?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      Reblog.ReblogAll();
      JOptionPane.showMessageDialog(App.win,
          "Reblogging all filtered posts was successful!", "Success!",
          JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      return;
    }
  }
}
