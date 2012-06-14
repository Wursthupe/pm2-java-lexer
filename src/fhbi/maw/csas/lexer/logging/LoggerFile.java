package fhbi.maw.csas.lexer.logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ein Logger der mit zwei Handlern in zwei verschiedene Datein schreibt.
 * 
 * @author Alexander Sundermann
 * @author Christian Stührmann
 * @version 1.0
 */

public class LoggerFile {

	private Logger loggerFile;
	private MyFileFormatter formatter;
	private FileHandler fileHandler_all;
	private FileHandler fileHandler_nocomment;
	private String filePath;

	/**
	 * Die Klasse LoggerFile wird mit einem loggerNamen als String, einem filePath als String und einem Level, der den Logger markiert, initialisiert.
	 * Dieser Logger wird durch einen Handler, der auf einem veränderten Formatter zeigt, in der Ausgabe manipuliert.
	 * 
	 * Dieser Logger wird Zweck entfremdet, er wird nicht genutzt Programm Informationen auszugeben, sondern die gefundne Token
	 * in zwei HTML - Dateien zu schreiben. Diese Dateien unterscheiden sich indem aufzeichenen der Kommentar-Token.
	 * 
	 * @param loggerName Name des Loggers
	 * @param filePath Pfad der QuellText - Datei
	 * @param level Level mit dem der Logger und der Handler initialisiert werden soll
	 */
	public LoggerFile(String loggerName, String filePath, Level level) {

		this.filePath = filePath;

		loggerFile = Logger.getLogger("File : " + loggerName);
		loggerFile.setLevel(Level.FINEST);

		// Formatter initalisieren
		formatter = new MyFileFormatter();

		// Handler iniatalisieren
		fileHandler_all = initFileHandler(filePath, true, level);
		fileHandler_nocomment = initFileHandler(filePath, false, level);

		if (level != Level.OFF) {	
			fileHandler_all.setLevel(Level.FINEST);
			fileHandler_nocomment.setLevel(Level.FINE);
			// Formatter setzen
			fileHandler_all.setFormatter(formatter);
			fileHandler_nocomment.setFormatter(formatter);

			// Handler setzen
			loggerFile.addHandler(fileHandler_all);
			loggerFile.addHandler(fileHandler_nocomment);
		}

	}

	private FileHandler initFileHandler(String path, boolean all, Level level)

	{
		if (level != Level.OFF) {
			// Ein Date-Objekt initalisieren um die aktuelle Uhrzeit des Systems
			// ausgeben zu können
			java.util.Date now = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"dd_MM_yyyy__HH_mm_ss");
			String time = sdf.format(now);

			// Datei anlegen wenn sie noch nicht existiert
			File file;

			if (all)
				file = new File(path.substring(0, path.length() - 4)
						+ "_AllToken_" + time + ".htm");
			else
				file = new File(path.substring(0, path.length() - 4)
						+ "_NoComment_" + time + ".htm");

			try {
				file.createNewFile();
				return new FileHandler(file.getPath());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Übergibt den Logger um das loggen zu ermöglichen
	 * @return Logger-Objekt
	 */
	public Logger getLogger() {
		return loggerFile;
	}

	/**
	 * Setzt das Level des Loggers und des Handlers
	 * @param level Level des Loggers und des Handlers
	 */
	public void setLevel(Level level) {
		loggerFile.setLevel(level);
	}

}
