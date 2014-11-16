package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import eecs285.GUI.TumblrReblogGUI;

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
        DefaultListModel<String> currentTags = TumblrReblogGUI.getTagDefaultListModel();
        List<Object> currentTagsArray = Arrays.asList(currentTags.toArray());
        if(currentTagsArray.contains(stringIter))
        {
          TumblrReblogGUI.getTagDefaultListModel().removeElement(
              stringIter);
        }
      }
      DefaultListModel<String> currentTags = TumblrReblogGUI.getTagDefaultListModel();
      String[] contents = new String[currentTags.getSize()];
      for(int iter = 0; iter < currentTags.getSize(); iter++)
      {
        contents[iter] = currentTags.elementAt(iter);
      }
      TumblrReblogGUI.getTagDefaultListModel().clear();
      TumblrReblogGUI.updateTagList(contents);
      
    }
    else
    {
      return;
    }
    DeleteTagsEvent.getFrameDialog().dispose();
  }
}
