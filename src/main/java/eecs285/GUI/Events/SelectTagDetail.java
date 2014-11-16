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

import eecs285.App;
import eecs285.GUI.TumblrReblogGUI;

public class SelectTagDetail extends MouseAdapter
{
  private static JDialog frameDialog;
  private static JPanel northPanel;
  private static JPanel southPanel;
  private static JLabel confirm;
  private static JButton deleteButton;
  private static CloseButton nothingButton;
  private static String selected;

  public void mouseClicked(MouseEvent event)
  {
    if( event.getClickCount() == 2 )
    {
      frameDialog = new JDialog(App.win, "Tag Information");
      northPanel = new JPanel(new FlowLayout());
      southPanel = new JPanel(new FlowLayout());

      int location = TumblrReblogGUI.getTagJList().locationToIndex(
          event.getPoint());
      selected = TumblrReblogGUI.getTagJList().getModel()
          .getElementAt(location);

      confirm = new JLabel("Would you like to do to this tag?",
          SwingConstants.CENTER);
      deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new SelectTagDetailActionListener());
      nothingButton = new CloseButton("Nothing");

      northPanel.add(confirm);
      southPanel.add(deleteButton);
      southPanel.add(nothingButton);

      frameDialog.getContentPane().setLayout(
          new BoxLayout(frameDialog.getContentPane(), BoxLayout.Y_AXIS));
      frameDialog.add(northPanel);
      frameDialog.add(southPanel);
      frameDialog.setModal(true);
      frameDialog.setResizable(false);
      frameDialog.pack();
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
