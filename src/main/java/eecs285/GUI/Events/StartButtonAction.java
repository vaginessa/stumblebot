package eecs285.GUI.Events;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import eecs285.App;
import eecs285.GUI.TumblrReblogGUI;

public class StartButtonAction implements ActionListener
{
  private static JDialog frameDialog;
  private static JLabel questionLabel;
  private static JLabel hoursLabel;
  private static JLabel minutesLabel;
  private static JLabel secondsLabel;
  private static JPanel northPanel;
  private static JPanel centerPanel;
  private static JPanel southPanel;
  private static JTextField hoursText;
  private static JTextField minutesText;
  private static JTextField secondsText;
  private static JButton okButton;
  private static CloseButton cancelButton;

  public void actionPerformed(ActionEvent event)
  {
    if(App.globalTagsSeeded.isEmpty())
    {
      JOptionPane.showMessageDialog(App.win,
          "Please seed some tag(s) before automating this program!",
          "Seed Before Automation",
          JOptionPane.WARNING_MESSAGE);
    }
    else
    {
      frameDialog = new JDialog(App.win, "Time Between Each Repost");

      northPanel = new JPanel(new FlowLayout());
      centerPanel = new JPanel(new FlowLayout());
      southPanel = new JPanel(new FlowLayout());

      questionLabel = new JLabel("How long between each set of reposts?",
          SwingConstants.CENTER);
      hoursLabel = new JLabel("Hours: ", SwingConstants.CENTER);
      minutesLabel = new JLabel("Minutes: ", SwingConstants.CENTER);
      secondsLabel = new JLabel("Seconds: ", SwingConstants.CENTER);
      hoursText = new JTextField(10);
      minutesText = new JTextField(10);
      secondsText = new JTextField(10);
      okButton = new JButton("OK");
      cancelButton = new CloseButton("Cancel");
      okButton.addActionListener(new StartButtonActionListener());

      northPanel.add(questionLabel);
      centerPanel.add(hoursLabel);
      centerPanel.add(hoursText);
      centerPanel.add(minutesLabel);
      centerPanel.add(minutesText);
      centerPanel.add(secondsLabel);
      centerPanel.add(secondsText);
      southPanel.add(okButton);
      southPanel.add(cancelButton);

      frameDialog.getContentPane().setLayout(
          new BoxLayout(frameDialog.getContentPane(), BoxLayout.Y_AXIS));
      frameDialog.add(northPanel);
      frameDialog.add(centerPanel);
      frameDialog.add(southPanel);
      frameDialog.setResizable(false);
      frameDialog.setModal(true);
      frameDialog.pack();
      frameDialog.setLocationRelativeTo(App.win);
      frameDialog.setVisible(true);

      TumblrReblogGUI.getFetchButton().setEnabled(false);
      TumblrReblogGUI.getFilterButton().setEnabled(false);
      TumblrReblogGUI.getRestoreButton().setEnabled(false);
      TumblrReblogGUI.getPostButton().setEnabled(false);
      TumblrReblogGUI.getStartButton().setEnabled(false);
      TumblrReblogGUI.getStopButton().setEnabled(true);
      TumblrReblogGUI.getTimeButton().setEnabled(true);
    }

  }

  public static JDialog getFrameDialog()
  {
    return frameDialog;
  }

  public static int getHours()
  {
    return Integer.parseInt(hoursText.getText());
  }

  public static int getMinutes()
  {
    return Integer.parseInt(minutesText.getText());
  }

  public static int getSeconds()
  {
    return Integer.parseInt(secondsText.getText());
  }
}
