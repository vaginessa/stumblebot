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

import com.tumblr.jumblr.types.Post;

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

  public static void deleteTag(String toDelete)
  {
    if( App.globalTagsSeeded.contains(toDelete) )
    {
      App.globalTagsSeeded.remove(toDelete);
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

  public static void deletePost(String toDeleteID)
  {
    long postID = Long.parseLong(toDeleteID);
    System.out.println(postID);
    for(Post postIter : App.globalPosts)
    {
      System.out.println(postIter.getId());
      if(postIter.getId().equals(postID))
      {
        App.globalPosts.remove(postIter);
        break;
      }
    }
  }

  public static void updatePosts()
  {
    java.util.Collections.sort(App.globalTagsSeeded);
    TumblrReblogGUI.saved = false;
    TumblrReblogGUI.getPostDefaultListModel().clear();
    for( Post postIter : App.globalPosts )
    {
      TumblrReblogGUI.getPostDefaultListModel().addElement(
          String.format("Blog Name: %s Post ID: %d Tags: %s",
              postIter.getBlogName(), postIter.getId(), postIter.getTags()));
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
