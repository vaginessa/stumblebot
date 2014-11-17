package eecs285.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import eecs285.App;
import eecs285.GUI.Events.AddPostFromURLEvent;
import eecs285.GUI.Events.AddTagsEvent;
import eecs285.GUI.Events.CloseWindowEvent;
import eecs285.GUI.Events.DeleteTagsEvent;
import eecs285.GUI.Events.ExitProgramEvent;
import eecs285.GUI.Events.FetchPostsAction;
import eecs285.GUI.Events.LoadListOfPostsEvent;
import eecs285.GUI.Events.LoadListOfTagsEvent;
import eecs285.GUI.Events.PostButtonActionListener;
import eecs285.GUI.Events.SaveListOfPostsEvent;
import eecs285.GUI.Events.SaveListOfTagsEvent;
import eecs285.GUI.Events.SelectPostDetail;
import eecs285.GUI.Events.SelectTagDetail;
import eecs285.GUI.Events.ShowSelectedPostsAction;
import eecs285.GUI.Events.ShowSelectedTagsAction;

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
  private static JMenuItem deleteTags;
  private static JMenuItem addPostFromURL;
  // Items for User Interface
  private static JLabel tagLabel;
  private static JLabel postLabel;
  private static JLabel credits;
  private static JPanel tagListPanel;
  private static JPanel postListPanel;
  private static JPanel allLists;
  private static JPanel buttonsRow1;
  // private static JPanel automatePanel;
  private static JPanel creditsPanel;
  private static JComboBox<String> tagsCombo;
  private static JComboBox<String> postsCombo;
  private static DefaultListModel<String> defaultTagList;
  private static DefaultListModel<String> defaultPostList;
  private static JList<String> tagList;
  private static JList<String> postList;
  private static JScrollPane tagScrollPane;
  private static JScrollPane postScrollPane;
  // private static JCheckBox automate;
  private static JButton fetchButton;
  private static JButton runButton;
  private static JButton postButton;

  public TumblrReblogGUI()
  {
    super("Tumblr Reblog Bot");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    createMenu();
    createUI();
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new CloseWindowEvent());
    setResizable(false);
    setVisible(true);

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
    addTags = new JMenuItem("Add Tag(s)");
    deleteTags = new JMenuItem("Delete Tag(s)");
    addPostFromURL = new JMenuItem("Add Post From URL");
    loadListOfTags.addActionListener(new LoadListOfTagsEvent());
    loadListOfPosts.addActionListener(new LoadListOfPostsEvent());
    saveListOfTags.addActionListener(new SaveListOfTagsEvent());
    saveListOfPosts.addActionListener(new SaveListOfPostsEvent());
    exitProgram.addActionListener(new ExitProgramEvent());
    addTags.addActionListener(new AddTagsEvent());
    deleteTags.addActionListener(new DeleteTagsEvent());
    addPostFromURL.addActionListener(new AddPostFromURLEvent());
    fileMenu.add(loadListOfTags);
    fileMenu.add(loadListOfPosts);
    fileMenu.add(saveListOfTags);
    fileMenu.add(saveListOfPosts);
    fileMenu.add(exitProgram);
    editMenu.add(addTags);
    editMenu.add(deleteTags);
    editMenu.add(addPostFromURL);

    menuBar.add(fileMenu);
    menuBar.add(editMenu);

    setJMenuBar(menuBar);
  }

  private void createUI()
  {
    tagListPanel = new JPanel(new FlowLayout());
    postListPanel = new JPanel(new FlowLayout());
    allLists = new JPanel(new FlowLayout());
    buttonsRow1 = new JPanel(new FlowLayout());
    // automatePanel = new JPanel(new FlowLayout());
    creditsPanel = new JPanel(new FlowLayout());
    tagsCombo = new JComboBox<String>();
    postsCombo = new JComboBox<String>();

    tagsCombo.addItem("Show Seeded Tags");
    tagsCombo.addItem("Show Found Tags");
    tagsCombo.addActionListener(new ShowSelectedTagsAction());
    postsCombo.addItem("All Posts");
    postsCombo.addActionListener(new ShowSelectedPostsAction());

    tagLabel = new JLabel("All Currently Seeded Tags");
    tagLabel.setBorder(new EmptyBorder(10, 5, 5, 5));
    defaultTagList = new DefaultListModel<String>();
    tagList = new JList<String>(defaultTagList);
    tagList.addMouseListener(new SelectTagDetail());
    tagScrollPane = new JScrollPane(tagList);
    tagScrollPane.setPreferredSize(new Dimension(200, 400));

    tagListPanel.setLayout(new BoxLayout(tagListPanel, BoxLayout.Y_AXIS));
    tagListPanel.add(tagsCombo);
    tagListPanel.add(tagLabel);
    tagListPanel.add(tagScrollPane);
    tagListPanel.setBorder(new EmptyBorder(10, 10, 10, 5));

    postLabel = new JLabel("All Currently Listed Posts");
    postLabel.setBorder(new EmptyBorder(10, 5, 5, 5));
    defaultPostList = new DefaultListModel<String>();
    postList = new JList<String>(defaultPostList);
    postList.addMouseListener(new SelectPostDetail());
    postScrollPane = new JScrollPane(postList);
    postScrollPane.setPreferredSize(new Dimension(500, 400));

    postListPanel.setLayout(new BoxLayout(postListPanel, BoxLayout.Y_AXIS));
    postListPanel.add(postsCombo);
    postListPanel.add(postLabel);
    postListPanel.add(postScrollPane);
    postListPanel.setBorder(new EmptyBorder(10, 5, 10, 10));
    allLists.add(tagListPanel);
    allLists.add(postListPanel);

    fetchButton = new JButton("Update Posts From Seeded Tags");
    runButton = new JButton("Automatically Post");
    postButton = new JButton("Reblog All Posts");

    fetchButton.addActionListener(new FetchPostsAction());
    postButton.addActionListener(new PostButtonActionListener());
    
    //DEBUG OPTIONS
    JPanel debugOptions = new JPanel(new FlowLayout());
    JLabel debugText = new JLabel("Row of debuggin buttons");
    JButton allTypes = new JButton("Create Every Type of Post");
    allTypes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Simulator.addTag("answer");
        Simulator.addTag("audio");
        Simulator.addTag("chat");
        Simulator.addTag("link");
        Simulator.addTag("photo");
        Simulator.addTag("quote");
        Simulator.addTag("text");
        Simulator.addTag("video");
        Simulator.updateTags();
      }
    });
    JButton clearTags = new JButton("Clear ALL Tags");
    clearTags.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        App.globalTagsSeeded.clear();
        Simulator.updateTags();
      }
    });
    JButton clearPosts = new JButton("Clear ALL Posts");
    clearPosts.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        App.globalPosts.clear();
        Simulator.updatePosts();
      }
    });
    debugOptions.add(debugText);
    debugOptions.add(allTypes);
    debugOptions.add(clearTags);
    debugOptions.add(clearPosts);
    add(debugOptions);
    
    
    buttonsRow1.add(fetchButton);
    buttonsRow1.add(runButton);
    buttonsRow1.add(postButton);

    // automate = new JCheckBox("Automate Posts?", false);
    credits = new JLabel(
        "Created by J. Ames, D. Brooks, J. Hu, J. Jin, Y. Seetharaman"
            + " for EECS285 during Fall 2014.", SwingConstants.CENTER);

    // automatePanel.add(automate);
    creditsPanel.add(credits);
    add(allLists);
    add(buttonsRow1);
    // add(automatePanel);
    add(creditsPanel);
  }

  public static JList<String> getTagJList()
  {
    return tagList;
  }

  public static JList<String> getPostJList()
  {
    return postList;
  }

  public static JComboBox<String> getTagsCombo()
  {
    return tagsCombo;
  }

  public static JComboBox<String> getPostsCombo()
  {
    return postsCombo;
  }

  public static DefaultListModel<String> getTagDefaultListModel()
  {
    return defaultTagList;
  }

  public static DefaultListModel<String> getPostDefaultListModel()
  {
    return defaultPostList;
  }
}
