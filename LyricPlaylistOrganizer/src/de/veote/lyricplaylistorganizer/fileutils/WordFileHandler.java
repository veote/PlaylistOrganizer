package de.veote.lyricplaylistorganizer.fileutils;

import java.io.File;

public class WordFileHandler extends DefaultFileHandler {

	@Override
	public String getFileContent(File file) {
		// TODO Implement Word file reader with Apache POI
		// XWPFDocument document = new XWPFDocument(in);
		// XWPFWordExtractor ex = new XWPFWordExtractor(document);
		// String text = ex.getText();
		return "Word File Reader is not implemented yet";
	}
}
