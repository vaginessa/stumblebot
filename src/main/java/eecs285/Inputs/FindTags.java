package eecs285.Inputs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import com.tumblr.jumblr.types.Post;

public class FindTags
{
  static Integer maxTags = 10;

  public static List<String> findFrom(List<Post> inPosts)
  {
    Map<String, Integer> tagMap = new HashMap<String, Integer>();
    ValueComparator bvc = new ValueComparator(tagMap);
    TreeMap<String, Integer> sorted_tagMap = new TreeMap<String, Integer>(bvc);
    for( Post post : inPosts )
    {
      for( String tag : post.getTags() )
      {
        Integer val = tagMap.get(tag);
        tagMap.put(tag, val == null ? 1 : val + 1);
      }
    }
    sorted_tagMap.putAll(tagMap);
    List<String> topTags = new Vector<String>();
    for( Entry<String, Integer> entry : sorted_tagMap.entrySet() )
    {
      topTags.add(entry.getKey());
      if( topTags.size() == maxTags )
      {
        break;
      }
    }
    return topTags;
  }
}

// http://stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
class ValueComparator implements Comparator<String>
{

  Map<String, Integer> base;

  public ValueComparator(Map<String, Integer> base)
  {
    this.base = base;
  }

  // Note: this comparator imposes orderings that are inconsistent with equals.
  public int compare(String a, String b)
  {
    if( base.get(a) >= base.get(b) )
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }
}
