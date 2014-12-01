package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.Reblog.Reblog;

/**
 * Created by yogesh on 11/16/14.
 */
public class PostButtonAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    Reblog.ReblogAll();
    JOptionPane.showMessageDialog(App.win,
        "Reblogging all filtered posts was successful!", "Success!",
        JOptionPane.INFORMATION_MESSAGE);
  }
}
