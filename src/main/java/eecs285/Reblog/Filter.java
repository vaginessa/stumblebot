package eecs285.Reblog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

//Goal is to take post, then modify for reblog;

class PostBlogLikesComparator implements Comparator<Post>
{
  public int compare(Post a, Post b)
  {
    if( App.client.blogInfo(a.getBlogName()).getPostCount() >= App.client
        .blogInfo(b.getBlogName()).getPostCount() )
      return -1;
    else
      return 1;
  }
}

// Yogesh <-
public class Filter
{
  static int numPostsToReblog = 10;

  static Map<String, Map<String, Integer>> tagMap = new HashMap<>();
  static TreeSet<Post> postTreeSet;
  static HashSet<Long> alreadyPosted = new HashSet<>();

  // gets top n posts to reblog by checking poster's popularity
  public static List<Post> postsToReblog(List<Post> inPosts)
  {
    postTreeSet = new TreeSet<>(new PostBlogLikesComparator());
    postTreeSet.addAll(inPosts);

    List<Post> topNPosts = new ArrayList<>();

    Iterator<Post> it = postTreeSet.iterator();
    while( topNPosts.size() < numPostsToReblog && it.hasNext() )
    {
      Post p = it.next();
      long id = p.getId();
      if( !alreadyPosted.contains(id) )
      {
        alreadyPosted.add(id);
        topNPosts.add(p);
      }
    }
    /*
     * for (int i = 0; i < numPostsToReblog; ++i) topNPosts.add(it.next());
     */

    return topNPosts;
  }


  /*
   * Each Post is a list of tags List of of List of tags
   * 
   * Get a post, find another tag that post has been seen with
   * 
   * Input List of Lists, shoot out Hashmap <- Probably different functions Goal
   * is to build the Hashmap, you put in a post, in fires back associated tags;
   * add count if things occur multiple times;
   * 
   * 
   * HashMap<String, HashMap<String, int> > tagMap First HashMap maps tag (aka a
   * post title) to another Hashmap; Second Hashmap maps Strings to ints.
   * 
   * You can iterate through maps, so use that to find top n tags, assemble into
   * list and push out
   */
  static List<String> tagsFromPost(Post inPost)
  {
    List<String> postTags = inPost.getTags();
    HashSet<String> returnTags = new HashSet<>();
    int count = 0;

    for( String tag : postTags )
    {
      if( !tagMap.containsKey(tag) )
      {
        tagMap.put(tag, new HashMap<String, Integer>());
      }

      for( String tag2 : postTags )
      {
        if( !tagMap.get(tag).containsKey(tag2) )
        {
          tagMap.get(tag).put(tag2, 1);
        }
        else
        {
          count = tagMap.get(tag).get(tag2);
          tagMap.get(tag).put(tag2, count + 1);
        }
      }
    }

    for( String tag : postTags )
    {
      for( String tag2 : tagMap.get(tag).keySet() )
      {
        returnTags.add(tag2);
      }
      if( returnTags.size() > 20 )
        break;
    }
    List<String> tagsStrings = new ArrayList<String>(returnTags);

    System.out.println("Tags for post: " + inPost);
    for( String tag : tagsStrings )
      System.out.println(tag);
    System.out.println();

    return tagsStrings;
  }

  static String titleForPost(Post inPost)
  {
    return inPost.getBlogName() + " Repost";
  }

  static void getTextForPost(Post inPost)
  {
    //List<String> tags = inPost.getTags();
  }
}
