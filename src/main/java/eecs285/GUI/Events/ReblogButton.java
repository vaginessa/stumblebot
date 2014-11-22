package eecs285.GUI.Events;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

public class ReblogButton extends JButton implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private static Post selectedPost;
  private static JDialog frameDialog;
  private static JLabel tagsLabel;
  private static JLabel messageLabel;
  private static JTextArea tagsTextArea;
  private static JTextArea messageTextArea;
  private static JScrollPane tagsScrollPane;
  private static JScrollPane messageScrollPane;
  private static JPanel tagsLabelPanel;
  private static JPanel tagsPanel;
  private static JPanel messageLabelPanel;
  private static JPanel messagePanel;
  private static JPanel buttonPanel;
  private static JButton confirmButton;
  private static CloseButton cancelButton;

  public ReblogButton(Post inPost)
  {
    super("Reblog This Post");
    selectedPost = inPost;
    addActionListener(this);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    frameDialog = new JDialog(App.win, "Reblogging This Post");
    tagsLabelPanel = new JPanel(new FlowLayout());
    tagsPanel = new JPanel(new FlowLayout());
    messageLabelPanel = new JPanel(new FlowLayout());
    messagePanel = new JPanel(new FlowLayout());
    buttonPanel = new JPanel(new FlowLayout());

    tagsLabel = new JLabel(
        "What tags would you like to include in your reblog?");
    tagsLabelPanel.add(tagsLabel);
    tagsTextArea = new JTextArea();
    tagsScrollPane = new JScrollPane(tagsTextArea);
    tagsScrollPane.setPreferredSize(new Dimension(500, 100));
    tagsPanel.add(tagsScrollPane);

    messageLabel = new JLabel(
        "What message would you like to include with your reblog?");
    messageLabelPanel.add(messageLabel);
    messageTextArea = new JTextArea();
    messageScrollPane = new JScrollPane(messageTextArea);
    messageScrollPane.setPreferredSize(new Dimension(500, 100));
    messagePanel.add(messageScrollPane);

    confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(new ReblogConfirmActionListener());
    cancelButton = new CloseButton("Cancel");

    buttonPanel.add(confirmButton);
    buttonPanel.add(cancelButton);

    frameDialog.getContentPane().setLayout(
        new BoxLayout(frameDialog.getContentPane(), BoxLayout.Y_AXIS));
    frameDialog.add(tagsLabelPanel);
    frameDialog.add(tagsPanel);
    frameDialog.add(messageLabelPanel);
    frameDialog.add(messagePanel);
    frameDialog.add(buttonPanel);
    frameDialog.setResizable(false);
    frameDialog.setModal(true);
    frameDialog.pack();
    frameDialog.setLocationRelativeTo(App.win);
    frameDialog.setVisible(true);
  }

  public static JDialog getFrameDialog()
  {
    return frameDialog;
  }

  public static Post getSelectedPost()
  {
    return selectedPost;
  }

  public static String getTagsText()
  {
    return tagsTextArea.getText();
  }

  public static String getMessageText()
  {
    return messageTextArea.getText();
  }
}
