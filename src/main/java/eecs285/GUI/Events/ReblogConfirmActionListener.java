package eecs285.GUI.Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.tumblr.jumblr.types.Post;

public class ReblogConfirmActionListener implements ActionListener
{
  private static Post selectedPost;
  private static List<String> insertTags;

  public void actionPerformed(ActionEvent event)
  {
    if( JOptionPane.showConfirmDialog(DeleteTagsEvent.getFrameDialog(),
        "Are you sure reblog this post?", "Confirmation",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION )
    {
      insertTags = new ArrayList<String>();
      selectedPost = ReblogButton.getSelectedPost();
      System.out.println(selectedPost.toString());
      String tagsInput = ReblogButton.getTagsText().replaceAll("\\s+", "");
      System.out.println(tagsInput);
      String[] tagsInputParse = tagsInput.split(",");
      for( String stringIter : tagsInputParse )
      {
        if(!insertTags.contains(stringIter))
        {
          insertTags.add(stringIter);
        }
      }
      selectedPost.setTags(insertTags);
      String messageInput = ReblogButton.getMessageText();
      // Set Message here
      System.out.println("Reblog post " + selectedPost.toString());
      System.out.println("With Tags: ");
      for(String stringIter : selectedPost.getTags())
      {
        System.out.print(stringIter + ", ");
      }
      System.out.println();
      System.out.println("With Message: " + messageInput);
      System.out.println("Now following " + selectedPost.getBlogName());
      // selectedPost.reblog(App.ourBlog.getTitle());
      // App.client.blogInfo(selectedPost.getBlogName()).follow();
      ReblogButton.getFrameDialog().dispose();
      SelectPostDetail.getFrameDialog().dispose();
    }
    else
    {
      return;
    }
  }
}
