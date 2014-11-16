package eecs285.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import eecs285.App;

public class Simulator
{
  public static void addTag(String toAdd)
  {
    DefaultListModel<String> currentTags = TumblrReblogGUI
        .getTagDefaultListModel();
    List<Object> currentTagsArray = Arrays.asList(currentTags.toArray());
    if( !currentTagsArray.contains(toAdd) )
    {
      TumblrReblogGUI.getTagDefaultListModel().addElement(toAdd);
    }
  }

  public static void deleteTag(String todelete)
  {
    DefaultListModel<String> currentTags = TumblrReblogGUI
        .getTagDefaultListModel();
    List<Object> currentTagsArray = Arrays.asList(currentTags.toArray());
    if( currentTagsArray.contains(todelete) )
    {
      TumblrReblogGUI.getTagDefaultListModel().removeElement(todelete);
    }
  }

  public static void updateTags()
  {
    DefaultListModel<String> currentTags = TumblrReblogGUI
        .getTagDefaultListModel();
    String[] contents = new String[currentTags.getSize()];
    for( int iter = 0; iter < currentTags.getSize(); iter++ )
    {
      contents[iter] = currentTags.elementAt(iter);
    }
    Arrays.sort(contents);
    TumblrReblogGUI.saved = false;
    TumblrReblogGUI.getTagDefaultListModel().clear();
    TumblrReblogGUI.updateTagList(contents);
  }

  @SuppressWarnings("resource")
  public static String[] loadTags(File inputFile)
  {
    if( inputFile == null )
    {
      return null;
    }
    ArrayList<String> tagArray = new ArrayList<>();
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

    return tagArray.toArray(new String[tagArray.size()]);
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
