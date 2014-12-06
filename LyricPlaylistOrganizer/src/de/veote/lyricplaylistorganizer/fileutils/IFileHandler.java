package de.veote.lyricplaylistorganizer.fileutils;

import java.io.File;
import java.util.List;

import de.veote.lyricplaylistorganizer.model.SongFile;

public interface IFileHandler {
	public boolean isSongFileDirectoryAvailable(String directory);

	public String getFileContent(File file);

	public void loadFilesInDirectory(String directory);

	public List<SongFile> getFiles();
}
