package eecs285.Reblog;

import com.tumblr.jumblr.types.Post;

import eecs285.App;

import java.util.HashMap;
import java.util.List;
//Goal is to take post, then modify for reblog;
import java.util.Map;


// Yogesh <-
public class Filter
{
  static List<Post> postsToReblog(List<Post> inPosts)
  {
    return App.globalPosts;
  }
  
  
  /*
  Each Post is a list of tags
  List of of List of tags
 
   Get a post, find another tag that post has been seen with
 
  Input List of Lists, shoot out Hashmap <- Probably different functions
   Goal is to build the Hashmap, you put in a post, in fires back associated tags;
  add count if things occur multiple times;
 
 
  * HashMap<String, HashMap<String, int> > tagMap
  * First HashMap maps tag (aka a post title) to another Hashmap;
  *  Second Hashmap maps Strings to ints.
  *  
  *  You can iterate through maps, so use that to find top n tags, assemble into list
  *  and push out
  */
  static List<String> tagsFromPost(Post inPost)
  {
	  Map<String, Integer> emptyMap = null; // Empty Map for reference;
	  Map<String, Map<String, Integer> > tagMap = null; //Map of the Map of Tags;
	  List<String> posttags = inPost.getTags();
	  List<String> returntags = null;
	  int temp = 0;
	  
	  for (int i = 0; i < posttags.size(); i++) { //For Each tag in the Main List.
		  String holder = posttags.get(i); //Grab the current Tag
		//If an entry for that Tag doesn't exist, make a new
		  if (!tagMap.containsKey(holder)) { 
			  tagMap.put(holder, emptyMap);  
		  }
		  
		  // For Each Map Entry, we need to run through Each tag again
		  for (int j = 0; j < posttags.size(); j++) {	
			  //if The entry for the tag doesn't exist, add it and set the count to 0;
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
}
