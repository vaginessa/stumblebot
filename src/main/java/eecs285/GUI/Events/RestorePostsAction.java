package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;

public class RestorePostsAction implements ActionListener
{
  public void actionPerformed(ActionEvent actionEvent)
  {
    if( !TumblrReblogGUI.original )
    {
      App.globalPosts = App.globalPostsPreFilter;
      TumblrReblogGUI.original = true;
      TumblrReblogGUI.getRestoreButton().setEnabled(false);
      TumblrReblogGUI.getPostButton().setEnabled(false);
    }
    else
    {
      JOptionPane.showMessageDialog(App.win,
          "There are no pre-filtered posts to restore to!", "Warning",
          JOptionPane.INFORMATION_MESSAGE);
    }
    Simulator.updatePosts();
  }
}
