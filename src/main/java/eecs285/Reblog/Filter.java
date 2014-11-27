package eecs285.Reblog;

import com.tumblr.jumblr.types.Post;
import eecs285.App;

import java.util.*;

//Goal is to take post, then modify for reblog;

class PostBlogLikesComparator implements Comparator<Post>
{
  public int compare(Post a, Post b)
  {
    if ( App.client.blogInfo(a.getBlogName()).getLikeCount()
            >= App.client.blogInfo(b.getBlogName()).getLikeCount())
      return -1;
    else
      return 1;
  }
}

// Yogesh <-
public class Filter
{
  static int numPostsToReblog = 5;

  static TreeSet<Post> postTreeSet;

  // gets top n posts to reblog by checking poster's popularity
  static List<Post> postsToReblog(List<Post> inPosts) {
    postTreeSet = new TreeSet<>(new PostBlogLikesComparator());
    postTreeSet.addAll(inPosts);

    List<Post> topNPosts = new ArrayList<>();

    Iterator<Post> it = postTreeSet.iterator();
    for (int i = 0; i < numPostsToReblog; ++i)
      topNPosts.add(it.next());

    return topNPosts;
  }

  
  /*
  Each Post is a list of tags
  List of of List of tags
 
  Get a post, find another tag that post has been seen with
 
  Input List of Lists, shoot out Hashmap <- Probably different functions
  Goal is to build the Hashmap, you put in a post,
  in fires back associated tags;
  add count if things occur multiple times;
 
 
  * HashMap<String, HashMap<String, int> > tagMap
  * First HashMap maps tag (aka a post title) to another Hashmap;
  *  Second Hashmap maps Strings to ints.
  *  
  *  You can iterate through maps, so use that to find top n tags, assemble
  *  into list
  *  and push out
  */
  static List<String> tagsFromPost(Post inPost)
  {
	  Map<String, Integer> emptyMap = null; // Empty Map for reference;
	  Map<String, Map<String, Integer> > tagMap = null;//Map of the Map of Tags;
	  List<String> posttags = inPost.getTags();
	  List<String> returntags = null;
	  int temp = 0;

      //For Each tag in the Main List.
	  for (int i = 0; i < posttags.size(); i++) {
		  String holder = posttags.get(i); //Grab the current Tag
		//If an entry for that Tag doesn't exist, make a new
		  if (!tagMap.containsKey(holder)) { 
			  tagMap.put(holder, emptyMap);  
		  }
		  
		  // For Each Map Entry, we need to run through Each tag again
		  for (int j = 0; j < posttags.size(); j++) {	
			  //if The entry for the tag doesn't exist, add it
			  // and set the count to 0;
			  if(!tagMap.get(holder).containsKey(posttags.get(i))) {
				  tagMap.get(holder).put(posttags.get(i), 0);
			  }
			  
			  //otherwise, we just need to increase the count of the tag by 1;
			  temp = tagMap.get(holder).get(posttags.get(i));
			  temp++;
			  temp = tagMap.get(holder).put(posttags.get(i), temp);
			  
			  //Set the If condition to add to the List of Strings.
			  
		  }  
		}
	  
    return returntags;
  }
  
  static String titleForPost(Post inPost)
  {
    return inPost.getBlogName() + " Repost";
  }

  static void getTextForPost(Post inPost)
  {
    List<String> tags = inPost.getTags();
  }
}
