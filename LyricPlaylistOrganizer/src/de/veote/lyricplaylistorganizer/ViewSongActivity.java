package de.veote.lyricplaylistorganizer;

import java.io.File;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.veote.lyricplaylistorganizer.fileutils.DefaultFileHandler;
import de.veote.lyricplaylistorganizer.fileutils.IFileHandler;

public class ViewSongActivity extends ActionBarActivity {

	private static final String LOG_TAG = ViewSongActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_song);
		// if (savedInstanceState == null) {
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }

		Intent intent = getIntent();
		File selectedFile = (File) intent
				.getSerializableExtra(AllSongsAcitivity.SELECTED_FILE);
		Log.i(LOG_TAG, "Chose selected file : " + selectedFile);
		TextView songTextView = (TextView) findViewById(R.id.songText2);
		songTextView.setMovementMethod(new ScrollingMovementMethod());
		Log.i(LOG_TAG, "Textview: " + songTextView);
		// TextView text = new TextView(this);
		// text.setText(selectedFile.getName());
		IFileHandler fileHandler = new DefaultFileHandler();
		songTextView.setText(fileHandler.getFileContent(selectedFile));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_song, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_view_song,
					container, false);
			return rootView;
		}
	}
}
