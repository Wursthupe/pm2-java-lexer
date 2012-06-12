package fhbi.maw.csas.lexer.logging;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerConsole {
	
	private Logger loggerConsole;
	private MyConsoleFormatter formatter;
	private ConsoleHandler consoleHandler;

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

	public Logger getLogger()
	{
		return loggerConsole;
	}
	
	public void setLevel(Level level)
	{
		loggerConsole.setLevel(level);
	}


}
