package fhbi.maw.csas.lexer.logging;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerFile {

	private Logger loggerFile;
	private MyFileFormatter formatter;
	private FileHandler fileHandler_all;
	private FileHandler fileHandler_nocomment;
	private String filePath;

	public LoggerFile(String loggerName, String filePath, Level level) {

		this.filePath = filePath;

		loggerFile = Logger.getLogger("File : " + loggerName);
		loggerFile.setLevel(Level.FINEST);

		// Formatter initalisieren
		formatter = new MyFileFormatter();

		// Handler iniatalisieren
		fileHandler_all = initFileHandler(filePath,true);		
		fileHandler_nocomment = initFileHandler(filePath,false);
		
		
		if(level==Level.OFF)
		{
			fileHandler_all.setLevel(Level.OFF);
			fileHandler_nocomment.setLevel(Level.OFF);
		}else
		{
			fileHandler_all.setLevel(Level.FINEST);
			fileHandler_nocomment.setLevel(Level.FINE);
		}
		
		// Formatter setzen
		fileHandler_all.setFormatter(formatter);
		fileHandler_nocomment.setFormatter(formatter);

		// Handler setzen
		loggerFile.addHandler(fileHandler_all);
		loggerFile.addHandler(fileHandler_nocomment);

	}


	private FileHandler initFileHandler(String path, boolean all)

	{
		// Ein Date-Objekt initalisieren um die aktuelle Uhrzeit des Systems 
		// ausgeben zu können
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd_MM_yyyy__HH_mm_ss");
		String time = sdf.format(now);
		
		// Datei anlegen wenn sie noch nicht existiert
		File file;
		
		if (all)
			file = new File(path.substring(0, path.length() - 4) + "_AllToken_" + time + ".htm");
		else
			file = new File(path.substring(0, path.length() - 4) + "_NoComment_" + time + ".htm");
		
		try {
			file.createNewFile();
			return new FileHandler(file.getPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public String getFilePath() {
		return this.filePath;
	}

	public Logger getLogger() {
		return loggerFile;
	}

	public void setLevel(Level level) {
		loggerFile.setLevel(level);
	}

}
