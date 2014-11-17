package eecs285.GUI.Events;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import eecs285.App;
import eecs285.GUI.TumblrReblogGUI;

public class CloseWindowEvent implements WindowListener
{
  public void windowClosing(WindowEvent event)
  {
    if( App.globalTagsSeeded.isEmpty() && App.globalTagsFound.isEmpty() )
    {
      TumblrReblogGUI.saved = true;
    }
    if( TumblrReblogGUI.saved )
    {
      System.exit(0);
    }
    else
    {
      if( JOptionPane.showConfirmDialog(App.win,
          "Are you sure that you want to exit the program"
              + " without saving your tag list?", "Confirmation",
          JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
      {
        System.out.print("Yes");
        App.win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        App.win.setVisible(false);
        App.win.dispose();
      }
      else
      {
        System.out.print("No");
        App.win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      }
    }
  }

  @Override
  public void windowOpened(WindowEvent event)
  {
  }

  @Override
  public void windowClosed(WindowEvent event)
  {
  }

  @Override
  public void windowIconified(WindowEvent event)
  {
  }

  @Override
  public void windowDeiconified(WindowEvent event)
  {
  }

  @Override
  public void windowActivated(WindowEvent event)
  {
  }

  @Override
  public void windowDeactivated(WindowEvent event)
  {
  }

}
