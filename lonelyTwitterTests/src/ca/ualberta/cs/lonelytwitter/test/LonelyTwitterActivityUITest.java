package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
@SuppressLint("NewApi")
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testMakeTweet() throws Throwable {
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				makeTweet("TDD 4 LYFE #YOLO");
				//fail("failure");
			}
		});
		
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		
		LonelyTwitterActivity activity = getActivity();
		NormalTweetModel normalTweet = new NormalTweetModel(text);
		
		int prevCount =  activity.getAdapter().getCount();
		
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
		
		
		//makes sure new tweet is added
		assertEquals(activity.getAdapter().getCount(), prevCount + 1);
		//makes sure new tweet is normal
		//assertEquals(normalTweet.equals(activity.getAdapter().getItem( activity.getAdapter().getCount() -1 )), true);
		//assertEquals(activity.getAdapter().getItem( activity.getAdapter().getCount()).getClass().equals(normalTweet), true);
		assertEquals("should return False", false, normalTweet.equals(activity.getAdapter().getItem( activity.getAdapter().getCount()- 1)));

		assertEquals(activity.getAdapter().getItem(prevCount).getText(), text);
	}
}
