package eecs285.GUI.Events;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.tumblr.jumblr.types.AnswerPost;
import com.tumblr.jumblr.types.AudioPost;
import com.tumblr.jumblr.types.ChatPost;
import com.tumblr.jumblr.types.LinkPost;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.QuotePost;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.VideoPost;

import eecs285.App;
import eecs285.GUI.TumblrReblogGUI;


public class SelectPostDetail extends MouseAdapter
{
  private static JDialog frameDialog;
  private static JPanel northPanel;
  private static JPanel centerPanel;
  private static JPanel southPanel;
  private static JPanel leftPanel;
  private static JPanel rightPanel;
  private static JLabel confirm;
  private static JLabel timePosted;
  private static JLabel typeOfPost;
  private static JLabel IDOfPost;
  private static JLabel postAuthor;
  private static JLabel askerName;
  private static JLabel question;
  private static JLabel answer;
  private static JLabel trackName;
  private static JLabel chatBody;
  private static JLabel linkTitle;
  private static JLabel linkDescription;
  private static JLabel pictureCaption;
  private static JLabel quoteText;
  private static JLabel quoteSource;
  private static JLabel textBody;
  private static JLabel videoCaption;
  private static JLabel getTimePosted;
  private static JLabel getTypeOfPost;
  private static JLabel getIDOfPost;
  private static JLabel getPostAuthor;
  private static JLabel getAskerName;
  private static JLabel getQuestion;
  private static JLabel getAnswer;
  private static JLabel getTrackName;
  private static JLabel getChatBody;
  private static JLabel getLinkTitle;
  private static JLabel getLinkDescription;
  private static JLabel getPictureCaption;
  private static JLabel getQuoteText;
  private static JLabel getQuoteSource;
  private static JLabel getTextBody;
  private static JLabel getVideoCaption;
  private static OpenURLButton openButton;
  private static JButton deleteButton;
  private static CloseButton nothingButton;
  private static String selected;

  public void mouseClicked(MouseEvent event)
  {
    if( event.getClickCount() == 2 )
    {
      frameDialog = new JDialog(App.win, "Post Information");
      northPanel = new JPanel(new FlowLayout());
      centerPanel = new JPanel(new FlowLayout());
      southPanel = new JPanel(new FlowLayout());
      leftPanel = new JPanel(new FlowLayout());
      rightPanel = new JPanel(new FlowLayout());
      timePosted = new JLabel("Time Posted: ");
      typeOfPost = new JLabel("Type of Post: ");
      IDOfPost = new JLabel("ID of Post: ");
      postAuthor = new JLabel("Post Author: ");
      askerName = new JLabel("Asker Name: ");
      question = new JLabel("Question: ");
      answer = new JLabel("Answer: ");
      trackName = new JLabel("Track Name: ");
      chatBody = new JLabel("Chat Body: ");
      linkTitle = new JLabel("Link Title: ");
      linkDescription = new JLabel("Link Description: ");
      pictureCaption = new JLabel("Picture Caption: ");
      quoteText = new JLabel("Quote Text: ");
      quoteSource = new JLabel("Quote Source: ");
      textBody = new JLabel("Text Body: ");
      videoCaption = new JLabel("Video Caption: ");

      int location = TumblrReblogGUI.getPostJList().locationToIndex(
          event.getPoint());
      selected = TumblrReblogGUI.getPostJList().getModel()
          .getElementAt(location);
      confirm = new JLabel("Would you like to do to this post?",
          SwingConstants.CENTER);
      String splitSelected[] = selected.split(" ");
      Post toView = null;
      for( Post postIter : App.globalPosts )
      {
        long postID = Long.parseLong(splitSelected[5]);
        if( postIter.getId().equals(postID) )
        {
          toView = postIter;
          break;
        }
      }
      leftPanel.add(timePosted);
      leftPanel.add(typeOfPost);
      leftPanel.add(IDOfPost);
      leftPanel.add(postAuthor);
      getTimePosted = new JLabel(toView.getDateGMT());
      getTypeOfPost = new JLabel(toView.getType());
      getIDOfPost = new JLabel(toView.getId().toString());
      getPostAuthor = new JLabel(toView.getBlogName());
      rightPanel.add(getTimePosted);
      rightPanel.add(getTypeOfPost);
      rightPanel.add(getIDOfPost);
      rightPanel.add(getPostAuthor);
      if( toView.getType().equals("answer") )
      {
        leftPanel.add(askerName);
        leftPanel.add(question);
        leftPanel.add(answer);
        String askerNameString;
        String questionString;
        String answerString;
        if( ((AnswerPost) toView).getAskingName().length() > 60 )
        {
          askerNameString = ((AnswerPost) toView).getAskingName().substring(0,
              60)
              + "...";
        }
        else
        {
          askerNameString = ((AnswerPost) toView).getAskingName();
        }
        if( ((AnswerPost) toView).getQuestion().length() > 60 )
        {
          questionString = ((AnswerPost) toView).getQuestion().substring(0, 60)
              + "...";
        }
        else
        {
          questionString = ((AnswerPost) toView).getQuestion();
        }
        if( ((AnswerPost) toView).getAnswer().length() > 60 )
        {
          answerString = ((AnswerPost) toView).getAnswer().substring(0, 60)
              + "...";
        }
        else
        {
          answerString = ((AnswerPost) toView).getAnswer();
        }
        getAskerName = new JLabel(askerNameString + "\0");
        getQuestion = new JLabel(questionString + "\0");
        getAnswer = new JLabel(answerString + "\0");
        rightPanel.add(getAskerName);
        rightPanel.add(getQuestion);
        rightPanel.add(getAnswer);
      }
      else if( toView.getType().equals("audio") )
      {
        leftPanel.add(trackName);
        String trackNameString;
        if( ((AudioPost) toView).getTrackName().length() > 60 )
        {
          trackNameString = ((AudioPost) toView).getTrackName()
              .substring(0, 60) + "...";
        }
        else
        {
          trackNameString = ((AudioPost) toView).getTrackName();
        }
        getTrackName = new JLabel(trackNameString + "\0");
        rightPanel.add(getTrackName);
      }
      else if( toView.getType().equals("chat") )
      {
        leftPanel.add(chatBody);
        String chatBodyString;
        if( ((ChatPost) toView).getBody().length() > 60 )
        {
          chatBodyString = ((ChatPost) toView).getBody().substring(0, 60)
              + "...";
        }
        else
        {
          chatBodyString = ((ChatPost) toView).getBody();
        }
        getChatBody = new JLabel(chatBodyString + "\0");
        rightPanel.add(getChatBody);
      }
      else if( toView.getType().equals("link") )
      {
        leftPanel.add(linkTitle);
        leftPanel.add(linkDescription);
        String linkTitleString;
        String linkDescriptionString;
        if( ((LinkPost) toView).getTitle().length() > 60 )
        {
          linkTitleString = ((LinkPost) toView).getTitle().substring(0, 60)
              + "...";
        }
        else
        {
          linkTitleString = ((LinkPost) toView).getTitle();
        }
        if( ((LinkPost) toView).getDescription().length() > 60 )
        {
          linkDescriptionString = ((LinkPost) toView).getDescription()
              .substring(0, 60) + "...";
        }
        else
        {
          linkDescriptionString = ((LinkPost) toView).getDescription();
        }
        getLinkTitle = new JLabel(linkTitleString + "\0");
        getLinkDescription = new JLabel(linkDescriptionString + "\0");
        rightPanel.add(getLinkTitle);
        rightPanel.add(getLinkDescription);
      }
      else if( toView.getType().equals("photo") )
      {
        leftPanel.add(pictureCaption);
        String pictureCaptionString;
        if( ((PhotoPost) toView).getCaption().length() > 60 )
        {
          pictureCaptionString = ((PhotoPost) toView).getCaption().substring(0,
              60)
              + "...";
        }
        else
        {
          pictureCaptionString = ((PhotoPost) toView).getCaption();
        }
        getPictureCaption = new JLabel(pictureCaptionString + "\0");
        rightPanel.add(getPictureCaption);
      }
      else if( toView.getType().equals("quote") )
      {
        leftPanel.add(quoteText);
        leftPanel.add(quoteSource);
        String quoteTextString;
        String quoteSourceString;
        if( ((QuotePost) toView).getText().length() > 60 )
        {
          quoteTextString = ((QuotePost) toView).getText().substring(0, 60)
              + "...";
        }
        else
        {
          quoteTextString = ((QuotePost) toView).getText();
        }
        if( ((QuotePost) toView).getSource().length() > 60 )
        {
          quoteSourceString = ((QuotePost) toView).getSource().substring(0, 60)
              + "...";
        }
        else
        {
          quoteSourceString = ((QuotePost) toView).getSource();
        }
        getQuoteText = new JLabel(quoteTextString + "\0");
        getQuoteSource = new JLabel(quoteSourceString + "\0");
        rightPanel.add(getQuoteText);
        rightPanel.add(getQuoteSource);
      }
      else if( toView.getType().equals("text") )
      {
        leftPanel.add(textBody);
        String textBodyString;
        if( ((TextPost) toView).getBody().length() > 60 )
        {
          textBodyString = ((TextPost) toView).getBody().substring(0, 60)
              + "...";
        }
        else
        {
          textBodyString = ((TextPost) toView).getBody();
        }
        getTextBody = new JLabel(textBodyString + "\0");
        rightPanel.add(getTextBody);
      }
      else if( toView.getType().equals("video") )
      {
        leftPanel.add(videoCaption);
        String videoCaptionString;
        if( ((VideoPost) toView).getCaption().length() > 60 )
        {
          videoCaptionString = ((VideoPost) toView).getCaption().substring(0,
              60)
              + "...";
        }
        else
        {
          videoCaptionString = ((VideoPost) toView).getCaption();
        }
        getVideoCaption = new JLabel(videoCaptionString + "\0");
        rightPanel.add(getVideoCaption);
      }
      openButton = new OpenURLButton(toView);
      deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new SelectPostDetailActionListener());
      nothingButton = new CloseButton("Nothing");

      northPanel.add(leftPanel);
      northPanel.add(rightPanel);
      centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      centerPanel.add(confirm);
      southPanel.add(openButton);
      southPanel.add(deleteButton);
      southPanel.add(nothingButton);

      leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
      rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
      frameDialog.getContentPane().setLayout(
          new BoxLayout(frameDialog.getContentPane(), BoxLayout.Y_AXIS));
      frameDialog.add(northPanel);
      frameDialog.add(centerPanel);
      frameDialog.add(southPanel);
      frameDialog.setModal(true);
      frameDialog.setResizable(false);
      frameDialog.pack();
      frameDialog.setLocationRelativeTo(App.win);
      frameDialog.setVisible(true);
    }
  }

  public static String getSelected()
  {
    return selected;
  }

  public static JDialog getFrameDialog()
  {
    return frameDialog;
  }
}
