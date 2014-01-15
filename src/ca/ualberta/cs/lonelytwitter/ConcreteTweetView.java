package ca.ualberta.cs.lonelytwitter;


public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LoenelyTweetModel it)
	{

		return it.getTimestamp().toString() + " | " + it.getText();
		
	}

}
