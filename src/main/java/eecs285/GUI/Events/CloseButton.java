package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

// Creates a common button that closes a window upon being pressed
public class CloseButton extends JButton implements ActionListener
{
  private static final long serialVersionUID = 1L;

  public CloseButton(String buttonName)
  {
    super(buttonName);
    addActionListener(this);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event)
  {
    SwingUtilities.getWindowAncestor(this).dispose();
  }
}
