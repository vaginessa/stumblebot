package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import eecs285.App;
import eecs285.GUI.Simulator;
import eecs285.GUI.TumblrReblogGUI;

public class LoadListOfTagsEvent implements ActionListener
{
  private static JFileChooser chooser;
  private static int chooserReturn;
  private static File chosenFile;

  public void actionPerformed(ActionEvent event)
  {
    chooser = new JFileChooser();
    chooser.setDialogTitle("Load Tags");
    chooserReturn = chooser.showOpenDialog(App.win);
    if( chooserReturn == JFileChooser.APPROVE_OPTION )
    {
      chosenFile = chooser.getSelectedFile();
      for(String stringIter : Simulator.loadTags(chosenFile))
      {
        DefaultListModel<String> currentTags = TumblrReblogGUI.getTagDefaultListModel();
        List<Object> currentTagsArray = Arrays.asList(currentTags.toArray());
        if(!currentTagsArray.contains(stringIter))
        {
          TumblrReblogGUI.getTagDefaultListModel().addElement(
              stringIter);
        }
      }
      Simulator.updateTags();
    }
  }
}
