package eecs285.Inputs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.tumblr.jumblr.types.*;

public class FindTags
{
  static Integer maxTags = 50;
  
  private class pQueueComparator implements Comparator<Entry<String, Integer>>
  {
    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
    {
      return o1.getValue() - o2.getValue();
    }
  }
  
  static List<String> findFrom(List<Post> inPosts)
  {
    Map<String, Integer> tagMap = new HashMap<String, Integer>();
    for(Post post : inPosts)
    {
      for(String tag : post.getTags())
      {
        Integer val = tagMap.get(tag);
        tagMap.put(tag, val == null ? 1 : val + 1);
      }
    }
    Comparator<Entry<String, Integer>> pQueuecomp = new pQueueComparator();
    PriorityQueue<Entry<String, Integer>> pQueue = new PriorityQueue<Entry<String, Integer>>(tagMap.size(), pQueuecomp);
    for(Entry<String, Integer> entry : tagMap.entrySet())
    {
      pQueue.add(entry);
    }
    List<String> topTags = new Vector<String>();
    //topTags.addAll((1..maxTags).collect{pQueue.poll();};
    return topTags;
  }
}


