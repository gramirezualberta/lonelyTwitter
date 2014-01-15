package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class ImportantTweetModel extends LoenelyTweetModel
{

	public ImportantTweetModel(String text, Date timestamp)
	{

		super(text, timestamp);
		// TODO Auto-generated constructor stub
	}

	public ImportantTweetModel(String text)
	{

		super(text);
		// TODO Auto-generated constructor stub
	}

	
	public void setText(String text)
	{
	
		this.text = text;
	}
	
	/*public String determinateTweet()
	{
		
		return "[Important]";
		
	}
	*/
	
	public void setImportant(boolean important) throws Exception
	{
		if (important)
		{
			throw new IllegalArgumentException();
		}
		this.important = important;
	}

}
