package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.Simulator;

public class ShowSelectedPostsAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    Simulator.updatePosts();
  }
}
