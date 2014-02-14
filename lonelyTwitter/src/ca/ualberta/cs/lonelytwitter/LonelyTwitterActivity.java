package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.json";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweetModel> tweets;
	private ArrayAdapter<NormalTweetModel> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		
		String [] tweets= loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tweets);
		oldTweetsList.setAdapter(adapter);
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
<<<<<<< HEAD:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				saveInFile(text, new Date(System.currentTimeMillis()));
				((BaseAdapter) oldTweetsList.getAdapter()).notifyDataSetChanged();

=======
				NormalTweetModel tweet = new NormalTweetModel(text);
				saveInFile(tweet);
				tweets.add(tweet);
				adapter.notifyDataSetChanged();
>>>>>>> upstream/master:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			}
		});
	}
	

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
<<<<<<< HEAD:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		String [] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
=======
		tweets = loadFromFile();
		adapter = new ArrayAdapter<NormalTweetModel>(this,
>>>>>>> upstream/master:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(NormalTweetModel.fromJSON(line));
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	private void saveInFile(NormalTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
<<<<<<< HEAD:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			fos.write(new String(date.toString() + " | " + text +"/n")
					.getBytes());
=======
			fos.write((tweet.toJSON() + "\n").getBytes());
>>>>>>> upstream/master:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayAdapter<NormalTweetModel> getAdapter() {
		return adapter;
	}
	
}