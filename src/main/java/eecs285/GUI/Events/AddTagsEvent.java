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

public class AddTagsEvent implements ActionListener
{
  private static JDialog frameDialog;
  private static JLabel tagsLabel;
  private static JPanel northPanel;
  private static JPanel centerPanel;
  private static JPanel southPanel;
  private static JTextField tagsText;
  private static JButton okButton;
  private static CloseButton cancelButton;
  public void actionPerformed(ActionEvent event)
  {
    frameDialog = new JDialog(App.win, "Adding these tag(s)");

    northPanel = new JPanel(new FlowLayout());
    centerPanel = new JPanel(new FlowLayout());
    southPanel = new JPanel(new FlowLayout());

    tagsLabel = new JLabel(
        "Please enter the tag(s) you wish you wish to add," +
        " seperated by a comma. Spaces will be ignored!",
        SwingConstants.CENTER);
    tagsText = new JTextField(40);
    okButton = new JButton("OK");
    cancelButton = new CloseButton("Cancel");
    okButton.addActionListener(new AddTagsActionListener());

    northPanel.add(tagsLabel);
    centerPanel.add(tagsText);
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
    frameDialog.setVisible(true);
  }

  public static JDialog getFrameDialog()
  {
    return frameDialog;
  }

  public static String getText()
  {
    return tagsText.getText();
  }
}
