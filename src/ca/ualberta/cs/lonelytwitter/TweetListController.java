package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetListController
{
	
	private static TweetListModel tweerListModel; 

	public TweetListController()
	{
		super ();
		if(tweerListModel == null)
		{
			tweerListModel = new TweetListModel();
		}
	}
	
	public void addTweet( String text)
	{
		
		LoenelyTweetModel it = new NormalTweetModel(text);
		ArrayList <LoenelyTweetModel> list = tweerListModel.getList();
		list.add(it);
		
	}
}
