package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class LoenelyTweetModel
{
	
	protected String text;
	protected Date timestamp;
	
	public LoenelyTweetModel(String text, Date timestamp)
	{

		super();
		this.text = text;
		this.timestamp = timestamp;
	}

	public LoenelyTweetModel(String text)
	{

		super();
		this.text = text;
		this.timestamp = new Date();
	}
	
	public String getText()
	{
	
		return text;
	}

	
	public abstract void setText(String text);

	
	public Date getTimestamp()
	{
	
		return timestamp;
	}

	
	public void setTimestamp(Date timestamp)
	{
	
		this.timestamp = timestamp;
	}
	
	public abstract String determinateTweet();

}
