package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import eecs285.GUI.Simulator;

public class DeleteTagsActionListener implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(DeleteTagsEvent.getFrameDialog(),
        "Are you sure you want to delete these tag(s)?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      String userInput = DeleteTagsEvent.getText().replaceAll("\\s+","");
      System.out.println(userInput);
      String[] userInputParse = userInput.split(",");
      for(String stringIter : userInputParse)
      {
        Simulator.deleteTag(stringIter);
      }
      Simulator.updateTags();
      DeleteTagsEvent.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
