package eecs285.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import eecs285.App;

public class Simulator
{
  public static void addTag(String toAdd)
  {
    if( !App.globalTagsSeeded.contains(toAdd) )
    {
      App.globalTagsSeeded.add(toAdd);
    }
  }

  public static void deleteTag(String todelete)
  {
    if( App.globalTagsSeeded.contains(todelete) )
    {
      App.globalTagsSeeded.remove(todelete);
    }
  }

  public static void updateTags()
  {
    java.util.Collections.sort(App.globalTagsSeeded);
    TumblrReblogGUI.saved = false;
    TumblrReblogGUI.getTagDefaultListModel().clear();
    for( String tagIter : App.globalTagsSeeded )
    {
      TumblrReblogGUI.getTagDefaultListModel().addElement(tagIter);
    }
  }

  @SuppressWarnings("resource")
  public static List<String> loadTags(File inputFile)
  {
    if( inputFile == null )
    {
      return null;
    }
    List<String> tagArray = new Vector<String>();
    Scanner in;
    try
    {
      in = new Scanner(inputFile);
      while( in.hasNextLine() )
      {
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        tagArray.add(lineScanner.next());
      }
    }
    catch( FileNotFoundException event )
    {
      event.printStackTrace();
    }

    return tagArray;
  }

  public static void saveTagList(File outputFile) throws IOException
  {
    if( outputFile == null )
    {
      return;
    }
    try
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

      DefaultListModel<String> currentTags = TumblrReblogGUI
          .getTagDefaultListModel();
      for( int iter = 0; iter < currentTags.getSize(); iter++ )
      {
        writer.write(currentTags.elementAt(iter));
        writer.newLine();
      }

      writer.flush();
      writer.close();

      JOptionPane.showMessageDialog(App.win, "All Tags Have Been Saved",
          "Saved Tags", JOptionPane.PLAIN_MESSAGE);
    }
    catch( IOException event )
    {
      throw new IOException(String.format("Error writing to file. Error: %s\n",
          event.getMessage()));
    }
  }
}
