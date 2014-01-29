package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class ImportantTweetModel extends LonelyTweetModel {

	public ImportantTweetModel(String text, Date timestamp) {
		super(text, timestamp);
	}

	public ImportantTweetModel(String text) {
		super(text);
	}
	
	public String getText() {
		return "Important! " + super.getText();
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}
	
	public boolean equals(Object other) {
		if (other == null || !(other instanceof ImportantTweetModel)) {
			return false;
		}
		
		LonelyTweetModel otherTweet = (ImportantTweetModel) other;
		return timestamp.equals(otherTweet.timestamp) && text.equals(otherTweet.text);
	}

}
