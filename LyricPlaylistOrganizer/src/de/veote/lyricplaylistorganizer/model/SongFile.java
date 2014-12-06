package de.veote.lyricplaylistorganizer.model;

import java.io.File;

public class SongFile {
	private File file;

	public SongFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return file.getName();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
