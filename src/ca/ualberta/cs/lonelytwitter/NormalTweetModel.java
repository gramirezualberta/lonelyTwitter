package ca.ualberta.cs.lonelytwitter;


public class NormalTweetModel extends LoenelyTweetModel
{

	public NormalTweetModel(String text)
	{

		super(text);
	}

	@Override
	public void setText(String text)
	{

	}

	@Override
	/*public String determinateTweet()
	{
		return "[normal]";
	}*/
	
	public void setImporant(boolean important) throws Exception
	{
		if (important)
		{
			throw new IllegalArgumentException();
		}
		this.important = important;
	}

}
