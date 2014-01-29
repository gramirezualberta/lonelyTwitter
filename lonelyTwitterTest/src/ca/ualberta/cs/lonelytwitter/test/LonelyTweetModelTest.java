package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;


public class LonelyTweetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public LonelyTweetModelTest()
	{

		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}
	public void testFailure()
	{
		Date date = new Date(System.currentTimeMillis());
		LonelyTweetModel a = new ImportantTweetModel("hi",date);
		LonelyTweetModel b = new ImportantTweetModel("hi",date);
		assertEquals("it should be true", true, a.equals(b) );
		LonelyTweetModel c = new NormalTweetModel("hi",date);	
		LonelyTweetModel d = new NormalTweetModel("hi",date);
		LonelyTweetModel e = new NormalTweetModel("bye",date);
		assertEquals("it should be true", true, d.equals(c));
		assertEquals("it should be false", false, a.equals(c));
		assertEquals("it should be false", true, d.equals(e));
	}

}
