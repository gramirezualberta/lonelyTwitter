package ca.ualberta.cs.lonelytwitter;


public class ConcreteTweetView implements TweetView
{

	public String formatTweet(LoenelyTweetModel it)
	{

		// TODO Auto-generated method stub
		return it.getTimestamp().toString() + " | " + it.getText();
	}

}
