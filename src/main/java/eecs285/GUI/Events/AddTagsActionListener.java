package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.GUI.Simulator;

public class AddTagsActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(AddTagsEvent.getFrameDialog(),
        "Are you sure you want to add these tag(s)?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      String userInput = AddTagsEvent.getText().toLowerCase().replaceAll("\\s+", "");
      System.out.println(userInput);
      String[] userInputParse = userInput.split(",");
      for( String stringIter : userInputParse )
      {
        Simulator.addTag(stringIter);
      }
      Simulator.updateTags();
      AddTagsEvent.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
