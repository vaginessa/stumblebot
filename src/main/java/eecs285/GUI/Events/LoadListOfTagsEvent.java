package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import eecs285.App;
import eecs285.GUI.Simulator;

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
      for( String stringIter : Simulator.loadTags(chosenFile) )
      {
        if( !App.globalTagsSeeded.contains(stringIter) )
        {
          App.globalTagsSeeded.add(stringIter);
        }
      }
      Simulator.updateTags();
    }
  }
}
