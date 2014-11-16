package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.GUI.Simulator;

public class SelectPostDetailActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(App.win,
        "Are you sure you want to delete this post?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      String splitSelected[] = SelectPostDetail.getSelected().split(" ");
      System.out.println(splitSelected[5]);
      Simulator.deletePost(splitSelected[5]);
      Simulator.updatePosts();
      SelectPostDetail.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
