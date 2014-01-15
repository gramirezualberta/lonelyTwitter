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

	@Override
	public void setImporant(boolean important) throws Exception
	{

		// TODO Auto-generated method stub
		if (important)
		{
			throw new IllegalArgumentException();
		}
		this.important = important;
		
	}

}
