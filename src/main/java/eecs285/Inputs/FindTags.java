package eecs285.Inputs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
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
    ValueComparator bvc =  new ValueComparator(tagMap);
    TreeMap<String,Integer> sorted_tagMap = new TreeMap<String,Integer>(bvc);
    for(Post post : inPosts)
    {
      for(String tag : post.getTags())
      {
        Integer val = tagMap.get(tag);
        tagMap.put(tag, val == null ? 1 : val + 1);
      }
    }
    /*Comparator<Entry<String, Integer>> pQueuecomp = new pQueueComparator();
    PriorityQueue<Entry<String, Integer>> pQueue = new PriorityQueue<Entry<String, Integer>>(tagMap.size(), pQueuecomp);
    for(Entry<String, Integer> entry : tagMap.entrySet())
    {
      pQueue.add(entry);
    }
    List<String> topTags = new Vector<String>();*/
    sorted_tagMap.putAll(tagMap);
    for(int tagNum = 0; tagNum < maxTags; ++tagNum)
    {
      topTags.add(tagNum, pQueue.poll().getKey());
    }
    return topTags;
  }
}

//http://stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
class ValueComparator implements Comparator<String> {

  Map<String, Integer> base;
  public ValueComparator(Map<String, Integer> base) {
      this.base = base;
  }

  // Note: this comparator imposes orderings that are inconsistent with equals.    
  public int compare(String a, String b) {
      if (base.get(a) >= base.get(b)) {
          return -1;
      } else {
          return 1;
      }
  }
}

