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

  public static void deleteTagSeeded(String toDelete)
  {
    if( App.globalTagsSeeded.contains(toDelete) )
    {
      App.globalTagsSeeded.remove(toDelete);
    }
  }

  public static void deleteTagFound(String toDelete)
  {
    if( App.globalTagsFound.contains(toDelete) )
    {
      App.globalTagsFound.remove(toDelete);
    }
  }


  public static void updateTags()
  {
    java.util.Collections.sort(App.globalTagsSeeded);
    TumblrReblogGUI.saved = false;
    TumblrReblogGUI.getTagDefaultListModel().clear();
    TumblrReblogGUI.getPostsCombo().removeAllItems();
    TumblrReblogGUI.getPostsCombo().addItem("All Posts");
    addGlobalTagsSeeded();
  }

  public static void addGlobalTagsSeeded()
  {
    for( String tagIter : App.globalTagsSeeded )
    {
      if( TumblrReblogGUI.getTagsCombo().getSelectedItem() == "Show Seeded Tags" )
      {
        TumblrReblogGUI.getTagDefaultListModel().addElement(tagIter);
      }
      TumblrReblogGUI.getPostsCombo().addItem(tagIter);
    }
  }

  public static void addGlobalTagsFound()
  {
    for( String tagIter : App.globalTagsFound )
    {
      TumblrReblogGUI.getTagDefaultListModel().addElement(tagIter);
      TumblrReblogGUI.getPostsCombo().addItem(tagIter);
    }
  }

  public static void deletePost(String toDeleteID)
  {
    long postID = Long.parseLong(toDeleteID);
    System.out.println(postID);
    for( Post postIter : App.globalPosts )
    {
      System.out.println(postIter.getId());
      if( postIter.getId().equals(postID) )
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
    String selectedOption = (String) TumblrReblogGUI.getPostsCombo()
        .getSelectedItem();
    if( selectedOption == "All Posts" )
    {
      for( Post postIter : App.globalPosts )
      {
        TumblrReblogGUI.getPostDefaultListModel().addElement(
            String.format("Blog Name: %s Post ID: %d Tags: %s",
                postIter.getBlogName(), postIter.getId(), postIter.getTags()));

      }
    }
    else
    {
      for( Post postIter : App.globalPosts )
      {
        if( postIter.getTags().contains(selectedOption) )
        {
          TumblrReblogGUI.getPostDefaultListModel()
              .addElement(
                  String.format("Blog Name: %s Post ID: %d Tags: %s",
                      postIter.getBlogName(), postIter.getId(),
                      postIter.getTags()));

        }
      }
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
