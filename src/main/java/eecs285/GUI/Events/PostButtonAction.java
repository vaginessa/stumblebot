package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.Reblog.Reblog;

/**
 * Created by yogesh on 11/16/14.
 */
public class PostButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    @SuppressWarnings("unused")
    Reblog action = new Reblog();
  }
}
