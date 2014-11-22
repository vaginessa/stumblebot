package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.Utility.Timer;

public class GetTimeAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    long totalTime = Timer.getTimeSinceStart();
    int seconds = (int) (totalTime / 1000) % 60;
    int minutes = (int) ((totalTime / (1000 * 60)) % 60);
    int hours = (int) ((totalTime / (1000 * 60 * 60)) % 24);
    JOptionPane.showMessageDialog(App.win, hours + " Hours " + minutes
        + " Minutes " + seconds + " Seconds", "Total Runtime",
        JOptionPane.INFORMATION_MESSAGE);
  }
}
