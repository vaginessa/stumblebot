package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import eecs285.App;
import eecs285.GUI.Simulator;

public class SaveListOfTagsEvent implements ActionListener
{
  private static JFileChooser chooser;
  private static int chooserReturn;
  private static File chosenFile;

  public void actionPerformed(ActionEvent event)
  {
    chooser = new JFileChooser();
    chooser.setDialogTitle("Save List of Tags");
    chooserReturn = chooser.showSaveDialog(App.win);
    if( chooserReturn == JFileChooser.APPROVE_OPTION )
    {
      chosenFile = chooser.getSelectedFile();
      try
      {
        Simulator.saveTagList(chosenFile);
      }
      catch( IOException exceptionEvent )
      {
        System.out.printf(exceptionEvent.getMessage());
      }
    }
  }
}
