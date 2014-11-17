package eecs285.GUI.Events;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import eecs285.App;

public class AddPostFromURLEvent implements ActionListener
{
  private static JDialog frameDialog;
  private static JLabel URLLabel;
  private static JPanel northPanel;
  private static JPanel centerPanel;
  private static JPanel southPanel;
  private static JTextField URLText;
  private static JButton okButton;
  private static CloseButton cancelButton;

  public void actionPerformed(ActionEvent event)
  {
    frameDialog = new JDialog(App.win, "Adding Post From URL");

    northPanel = new JPanel(new FlowLayout());
    centerPanel = new JPanel(new FlowLayout());
    southPanel = new JPanel(new FlowLayout());

    URLLabel = new JLabel("Please enter the URL of the post you wish you add",
        SwingConstants.CENTER);
    URLText = new JTextField(40);
    okButton = new JButton("OK");
    cancelButton = new CloseButton("Cancel");
    okButton.addActionListener(new AddPostFromURLActionListener());

    northPanel.add(URLLabel);
    centerPanel.add(URLText);
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
  }

  public static JDialog getFrameDialog()
  {
    return frameDialog;
  }

}
