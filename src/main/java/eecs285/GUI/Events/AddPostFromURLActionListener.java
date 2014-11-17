package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPostFromURLActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    AddPostFromURLEvent.getFrameDialog().dispose();
  }
}
