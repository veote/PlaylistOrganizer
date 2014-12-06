package de.veote.lyricplaylistorganizer.model;

import java.io.File;

public class SongFile {
	private File file;

	public SongFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		String name = file.getName();
		name = name.substring(0, name.lastIndexOf('.'));
		return name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
