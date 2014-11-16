package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.GUI.Simulator;

public class SelectTagDetailActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(App.win,
        "Are you sure you want to delete this tag?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      String userInput = SelectTagDetail.getSelected();
      System.out.println(userInput);
      Simulator.deleteTag(userInput);
      Simulator.updateTags();
      SelectTagDetail.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
