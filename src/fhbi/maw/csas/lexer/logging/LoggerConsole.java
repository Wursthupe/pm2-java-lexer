package fhbi.maw.csas.lexer.logging;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ein Logger der auf der Console ein formatierten String ausgibt  
 * 
 * @author Alexander Sundermann
 * @author Christian Stührmann
 * @version 1.0
 */

public class LoggerConsole {
	
	private Logger loggerConsole;
	private MyConsoleFormatter formatter;
	private ConsoleHandler consoleHandler;
	
/**
 * Die Klasse LoggerConsole wird mit einem loggerNamen als String und einem Level, der den Logger markiert, initialisiert.
 * Dieser Logger wird durch einen Handler, der auf einem veränderten Formatter zeigt, in der Ausgabe manipuliert.
 * 
 * Dieser Logger wird Zweck entfremdet, er wird nicht genutzt Programm Informationen auszugeben, sondern
 * wird zu einer Art Printer umgebaut, der formatierte Strings auf der Konsole ausgibt. Diese Strings sind
 * Ergebnisse des MyLexers, diese werden als Text ausgegeben.
 * 
 * @param loggerName Name des Loggers
 * @param level Level des Loggers und des Handlers
 */
	public LoggerConsole(String loggerName, Level level) {


		// Logger initalisieren
		loggerConsole = Logger.getLogger("Ausgabe Konsole + " + loggerName);
		loggerConsole.setLevel(level);
		
		// Formatter initalisieren
		formatter = new MyConsoleFormatter();

		// Handler iniatalisieren
		consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(level);

		// Formatter setzen
		consoleHandler.setFormatter(formatter);
		
		// Handler setzen
		loggerConsole.addHandler(consoleHandler);
	}

	/**
	 * Übergibt den Logger um das loggen zu ermöglichen
	 * @return Logger-Objekt
	 */
	public Logger getLogger()
	{
		return loggerConsole;
	}
	
	/**
	 * Setzt das Level des Loggers und des Handlers
	 * @param level Level des Loggers und des Handlers
	 */
	public void setLevel(Level level)
	{
		loggerConsole.setLevel(level);
	}


}
