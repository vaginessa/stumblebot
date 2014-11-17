package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;

public class ShowSelectedTagsAction implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
    TumblrReblogGUI.getTagDefaultListModel().clear();
    String selectedOption = (String) TumblrReblogGUI.getTagsCombo()
        .getSelectedItem();
    if( selectedOption == "Show Seeded Tags" )
    {
      Simulator.addGlobalTagsSeeded();
    }
    else
    {
      Simulator.addGlobalTagsFound();
    }
  }
}
