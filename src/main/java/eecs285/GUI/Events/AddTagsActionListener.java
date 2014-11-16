package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import eecs285.GUI.TumblrReblogGUI;

public class AddTagsActionListener implements ActionListener
{

  @SuppressWarnings("unchecked")
  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(AddTagsEvent.getFrameDialog(),
        "Are you sure you want to add these tag(s)?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      String userInput = AddTagsEvent.getText().replaceAll("\\s+","");
      System.out.println(userInput);
      String[] userInputParse = userInput.split(",");
      DefaultListModel<String> currentTags = TumblrReblogGUI.getTagDefaultListModel();

      List<Object> currentTagsArray = Arrays.asList(currentTags.toArray());
      for(String stringIter : userInputParse)
      {
        if(!currentTagsArray.contains(stringIter))
        {
          TumblrReblogGUI.getTagDefaultListModel().addElement(
              stringIter);
        }
      }
    }
    else
    {
      return;
    }
    AddTagsEvent.getFrameDialog().dispose();
  }

}
