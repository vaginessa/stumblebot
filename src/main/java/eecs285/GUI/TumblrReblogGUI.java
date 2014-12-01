package eecs285.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import eecs285.GUI.Events.AddTagsEvent;
import eecs285.GUI.Events.CloseWindowEvent;
import eecs285.GUI.Events.DeleteTagsEvent;
import eecs285.GUI.Events.ExitProgramEvent;
import eecs285.GUI.Events.FetchPostsAction;
import eecs285.GUI.Events.FetchTagsAction;
import eecs285.GUI.Events.FilterPostsAction;
import eecs285.GUI.Events.GetTimeAction;
import eecs285.GUI.Events.LoadListOfTagsEvent;
import eecs285.GUI.Events.PostButtonAction;
import eecs285.GUI.Events.RestorePostsAction;
import eecs285.GUI.Events.SaveListOfPostsEvent;
import eecs285.GUI.Events.SaveListOfTagsEvent;
import eecs285.GUI.Events.SelectPostDetail;
import eecs285.GUI.Events.SelectTagDetail;
import eecs285.GUI.Events.ShowSelectedPostsAction;
import eecs285.GUI.Events.ShowSelectedTagsAction;
import eecs285.GUI.Events.StartButtonAction;
import eecs285.GUI.Events.StopButtonAction;

public class TumblrReblogGUI extends JFrame
{
  private static final long serialVersionUID = 1L;
  public static boolean saved = true;
  // Items for Menu
  private static JMenuBar menuBar;
  private static JMenu fileMenu;
  private static JMenu editMenu;
  private static JMenuItem loadListOfTags;
  private static JMenuItem saveListOfTags;
  private static JMenuItem saveListOfPosts;
  private static JMenuItem exitProgram;
  private static JMenuItem addTags;
  private static JMenuItem deleteTags;
  // Items for User Interface
  private static JLabel tagLabel;
  private static JLabel postLabel;
  private static JLabel automationText;
  private static JLabel credits;
  private static JPanel tagListPanel;
  private static JPanel postListPanel;
  private static JPanel allLists;
  private static JPanel buttonsRow1;
  private static JPanel buttonsRow2;
  private static JPanel automationTextPanel;
  private static JPanel automatePanel;
  private static JPanel creditsPanel;
  private static JComboBox<String> tagsCombo;
  private static JComboBox<String> postsCombo;
  private static DefaultListModel<String> defaultTagList;
  private static DefaultListModel<String> defaultPostList;
  private static JList<String> tagList;
  private static JList<String> postList;
  private static JScrollPane tagScrollPane;
  private static JScrollPane postScrollPane;
  private static JButton fetchPostsButton;
  private static JButton fetchTagsButton;
  private static JButton filterButton;
  private static JButton restoreButton;
  private static JButton postButton;
  private static JButton startButton;
  private static JButton stopButton;
  private static JButton getTimeButton;

  private static BufferedImage image;

  public TumblrReblogGUI()
  {
    super("Tumblr Reblog Bot");
    createBackground();
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    createMenu();
    createUI();
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new CloseWindowEvent());
    setResizable(false);
    setVisible(true);
  }

  private void createBackground()
  {
    try
    {
      image = ImageIO.read(new File("src/main/java/images/background.png"));
      setContentPane(new JLabel(new ImageIcon(image)));
    }
    catch( IOException event )
    {
      event.printStackTrace();
    }
  }

  private void createMenu()
  {
    menuBar = new JMenuBar();

    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");

    loadListOfTags = new JMenuItem("Load List Of Tags");
    saveListOfTags = new JMenuItem("Save List Of Tags");
    saveListOfPosts = new JMenuItem("Save List Of Posts");
    exitProgram = new JMenuItem("Exit Program");
    addTags = new JMenuItem("Add Tag(s)");
    deleteTags = new JMenuItem("Delete Tag(s)");

    loadListOfTags.addActionListener(new LoadListOfTagsEvent());
    saveListOfTags.addActionListener(new SaveListOfTagsEvent());
    saveListOfPosts.addActionListener(new SaveListOfPostsEvent());
    exitProgram.addActionListener(new ExitProgramEvent());
    addTags.addActionListener(new AddTagsEvent());
    deleteTags.addActionListener(new DeleteTagsEvent());

    fileMenu.add(loadListOfTags);
    fileMenu.add(saveListOfTags);
    fileMenu.add(saveListOfPosts);
    fileMenu.add(exitProgram);
    editMenu.add(addTags);
    editMenu.add(deleteTags);

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
    buttonsRow2 = new JPanel(new FlowLayout());
    automationTextPanel = new JPanel(new FlowLayout());
    automatePanel = new JPanel(new FlowLayout());
    creditsPanel = new JPanel(new FlowLayout());
    tagsCombo = new JComboBox<String>();
    postsCombo = new JComboBox<String>();

    tagsCombo.addItem("Show Seeded Tags");
    tagsCombo.addItem("Show Found Tags");
    tagsCombo.addActionListener(new ShowSelectedTagsAction());
    postsCombo.addItem("All Posts");
    postsCombo.addActionListener(new ShowSelectedPostsAction());

    tagLabel = new JLabel("Showing Selected Tags");
    tagLabel.setForeground(Color.white);
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

    postLabel = new JLabel("Showing Posts With Selected Tag");
    postLabel.setForeground(Color.white);
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

    fetchPostsButton = new JButton("Update Posts From Seeded Tags");
    fetchTagsButton = new JButton("Update Tags From Seeded Posts");
    filterButton = new JButton("Filter All Posts");
    restoreButton = new JButton("Restore Posts to Pre-Filtered State");
    postButton = new JButton("Reblog All Posts");
    restoreButton.setEnabled(false);
    postButton.setEnabled(false);

    fetchPostsButton.addActionListener(new FetchPostsAction());
    fetchTagsButton.addActionListener(new FetchTagsAction());
    filterButton.addActionListener(new FilterPostsAction());
    restoreButton.addActionListener(new RestorePostsAction());
    postButton.addActionListener(new PostButtonAction());

    buttonsRow1.add(fetchPostsButton);
    buttonsRow1.add(fetchTagsButton);
    buttonsRow1.add(filterButton);
    buttonsRow2.add(restoreButton);
    buttonsRow2.add(postButton);

    automationText = new JLabel("Automation Options:");
    automationText.setForeground(Color.white);
    automationTextPanel.add(automationText);

    startButton = new JButton("Start Automation");
    stopButton = new JButton("Stop Automation");
    getTimeButton = new JButton("Get Automation Time");
    stopButton.setEnabled(false);
    getTimeButton.setEnabled(false);

    startButton.addActionListener(new StartButtonAction());
    stopButton.addActionListener(new StopButtonAction());
    getTimeButton.addActionListener(new GetTimeAction());

    automatePanel.add(startButton);
    automatePanel.add(stopButton);
    automatePanel.add(getTimeButton);

    // DEBUG OPTIONS
    JPanel debugOptions = new JPanel(new FlowLayout());
    debugOptions.setOpaque(false);
    JLabel debugText = new JLabel("Row of debugging buttons: ");
    debugText.setForeground(Color.white);
    JButton allTypes = new JButton("Create Every Type of Post");
    allTypes.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
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
    clearTags.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        App.globalTagsSeeded.clear();
        Simulator.updateTags();
      }
    });
    JButton clearPosts = new JButton("Clear ALL Posts");
    clearPosts.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent event)
      {
        App.globalPosts.clear();
        Simulator.updatePosts();
      }
    });
    debugOptions.add(debugText);
    debugOptions.add(allTypes);
    debugOptions.add(clearTags);
    debugOptions.add(clearPosts);
    add(debugOptions);

    // End of debug options

    credits = new JLabel(
        "Created by J. Ames, D. Brooks, J. Hu, J. Jin, Y. Seetharaman"
            + " for EECS 285 during Fall 2014.", SwingConstants.CENTER);
    credits.setForeground(Color.white);
    creditsPanel.add(credits);

    tagListPanel.setOpaque(false);
    postListPanel.setOpaque(false);
    allLists.setOpaque(false);
    buttonsRow1.setOpaque(false);
    buttonsRow2.setOpaque(false);
    automationTextPanel.setOpaque(false);
    automatePanel.setOpaque(false);
    creditsPanel.setOpaque(false);

    add(allLists);
    add(buttonsRow1);
    add(buttonsRow2);
    add(automationTextPanel);
    add(automatePanel);
    add(creditsPanel);
  }

  public static JButton getFetchButton()
  {
    return fetchPostsButton;
  }

  public static JButton getFilterButton()
  {
    return filterButton;
  }

  public static JButton getRestoreButton()
  {
    return restoreButton;
  }

  public static JButton getPostButton()
  {
    return postButton;
  }

  public static JButton getStartButton()
  {
    return startButton;
  }

  public static JButton getStopButton()
  {
    return stopButton;
  }

  public static JButton getTimeButton()
  {
    return getTimeButton;
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
