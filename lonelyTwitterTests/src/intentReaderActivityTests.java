import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

@SuppressLint("NewApi")
public class intentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public intentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}

	public void testSendTest() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivit should get text from intent",
				text, activity.getText());
	}
	
	public void testDoubleTest() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivit should double the text",
				"hellohello", activity.getText());
	}
	
	public void testDisplaytest() {
		
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		TextView textView = (TextView)activity.findViewById
				(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertEquals("text should be displayed", text, textView.getText().toString());
				
	}
	
	public void testReverseTest() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivit should reverse the text",
				"olleh", activity.getText());
	}
	
	public void testDefaultMessage() {
		Intent intent = new Intent();
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivit should get default message",
				"No Message", activity.getText());
	}
	
	public void testTextView() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		boolean isShown = activity.getWindow().getDecorView().isShown(); 
		
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText)) ;
		
		//assertEquals("Textview should be visible", true, isShown );
	}
	
}
