package eecs285.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            String.format("Blog Name: %s Post ID: %d Post Type: %s",
                postIter.getBlogName(), postIter.getId(), postIter.getType()));

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
                  String.format("Blog Name: %s Post ID: %d Post Type: %s",
                      postIter.getBlogName(), postIter.getId(),
                      postIter.getType()));

        }
      }
    }
  }

  public static void loadTags(File inputFile)
  {
    boolean atSeeded = false;
    boolean atFound = false;
    if( inputFile == null )
    {
      return;
    }
    Scanner in;
    try
    {
      in = new Scanner(inputFile);
      while( in.hasNextLine() )
      {
        String line = in.nextLine();
        if( line.equals("//Seeded Tags") )
        {
          atSeeded = true;
        }
        else if( line.equals("//Found Tags") )
        {
          atSeeded = false;
          atFound = true;
        }
        if( atSeeded && !line.contains("//") )
        {
          addTag(line);
        }
        else if( atFound && !line.contains("//")
            && !App.globalTagsFound.contains(line) )
        {
          App.globalTagsFound.add(line);
        }
      }
    }
    catch( FileNotFoundException event )
    {
      event.printStackTrace();
    }
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

      writer.write("//Seeded Tags");
      writer.newLine();
      for( String stringIter : App.globalTagsSeeded )
      {
        writer.write(stringIter);
        writer.newLine();
      }
      writer.write("//Found Tags");
      writer.newLine();
      for( String stringIter : App.globalTagsFound )
      {
        writer.write(stringIter);
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

  public static void savePostList(File outputFile) throws IOException
  {
    if( outputFile == null )
    {
      return;
    }
    try
    {
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

      for( Post postIter : App.globalPosts )
      {
        writer.write(postIter.toString());
        writer.newLine();
        writer.write(postIter.getPostUrl());
        writer.newLine();
      }

      writer.flush();
      writer.close();

      JOptionPane.showMessageDialog(App.win, "All Posts Have Been Saved",
          "Saved Tags", JOptionPane.PLAIN_MESSAGE);
    }
    catch( IOException event )
    {
      throw new IOException(String.format("Error writing to file. Error: %s\n",
          event.getMessage()));
    }
  }
}
