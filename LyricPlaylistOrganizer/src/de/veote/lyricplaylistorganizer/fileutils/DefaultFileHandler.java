package de.veote.lyricplaylistorganizer.fileutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.os.Environment;
import android.util.Log;
import de.veote.lyricplaylistorganizer.model.SongFile;

public class DefaultFileHandler implements IFileHandler {
	private static final String LOG_TAG = DefaultFileHandler.class.getName();
	public static final String DEFAULT_DIRECTORY = "songfiles";

	private List<SongFile> textFiles;

	@Override
	public String getFileContent(File file) {
		StringBuilder out = new StringBuilder();
		try {
			InputStream in = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line + "\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out.toString();
	}

	@Override
	public void loadFilesInDirectory(String directory) {
		if (!isSongFileDirectoryAvailable(directory))
			throw new RuntimeException("Directory" + directory
					+ " is not available.");
		textFiles = new ArrayList<SongFile>();
		File dataDirectory = Environment
				.getExternalStoragePublicDirectory(directory);
		Log.i(LOG_TAG, "Song directory is mounted: " + dataDirectory);
		File[] files = dataDirectory.listFiles(new TextFileFilter());
		Arrays.sort(files);
		for (File file : files) {
			Log.i(LOG_TAG, "Found file: " + file);
			textFiles.add(new SongFile(file));
		}

	}

	@Override
	public List<SongFile> getFiles() {
		if (textFiles == null || textFiles.isEmpty())
			loadFilesInDirectory(DEFAULT_DIRECTORY);
		return textFiles;
	}

	@Override
	public boolean isSongFileDirectoryAvailable(String directory) {
		return Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())
				&& Environment.getExternalStoragePublicDirectory(directory) != null
				&& Environment.getExternalStoragePublicDirectory(directory)
						.canRead();
	}

	private class TextFileFilter implements FilenameFilter {

		@Override
		public boolean accept(File dir, String filename) {
			return filename.toLowerCase(Locale.GERMANY).endsWith(".txt");
		}

	}

}
