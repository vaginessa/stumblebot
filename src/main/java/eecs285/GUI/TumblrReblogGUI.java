package eecs285.GUI;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import eecs285.GUI.Events.*;

public class TumblrReblogGUI extends JFrame
{
  private static final long serialVersionUID = 1L;
  public static boolean saved = true;
  // Items for Menu
  private static JMenuBar menuBar;
  private static JMenu fileMenu;
  private static JMenu editMenu;
  private static JMenuItem loadListOfTags;
  private static JMenuItem loadListOfPosts;
  private static JMenuItem saveListOfTags;
  private static JMenuItem saveListOfPosts;
  private static JMenuItem exitProgram;
  private static JMenuItem addTags;
  private static JMenuItem addPostFromURL;
  // Items for User Interface
  private static JLabel credits;

  public TumblrReblogGUI()
  {
    super("Tumblr Reblog Bot");
    setLayout(
        new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    createMenu();
    createUI();
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  private void createMenu()
  {
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");
    loadListOfTags = new JMenuItem("Load List Of Tags");
    loadListOfPosts = new JMenuItem("Load List Of Posts");
    saveListOfTags = new JMenuItem("Save List Of Tags");
    saveListOfPosts = new JMenuItem("Save List Of Posts");
    exitProgram = new JMenuItem("Exit Program");
    addTags = new JMenuItem("Add Tag");
    addPostFromURL = new JMenuItem("Add Post From URL");
    loadListOfTags.addActionListener(new LoadListOfTagsEvent());
    loadListOfPosts.addActionListener(new LoadListOfPostsEvent());
    saveListOfTags.addActionListener(new SaveListOfTagsEvent());
    saveListOfPosts.addActionListener(new SaveListOfPostsEvent());
    exitProgram.addActionListener(new ExitProgramEvent());
    addTags.addActionListener(new AddTagsEvent());
    addPostFromURL.addActionListener(new AddPostFromURLEvent());
    fileMenu.add(loadListOfTags);
    fileMenu.add(loadListOfPosts);
    fileMenu.add(saveListOfTags);
    fileMenu.add(saveListOfPosts);
    fileMenu.add(exitProgram);
    editMenu.add(addTags);
    editMenu.add(addPostFromURL);

    menuBar.add(fileMenu);
    menuBar.add(editMenu);

    setJMenuBar(menuBar);
  }
  private void createUI()
  {
    credits = new JLabel("Created by J. Ames, D. Brooks, J. Hu, J. Jin, Y. Seetharaman"
        + " for EECS285 during Fall 2014.",
        SwingConstants.CENTER);
    add(credits);
  }
}
