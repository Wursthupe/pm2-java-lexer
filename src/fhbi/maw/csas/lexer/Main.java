package fhbi.maw.csas.lexer;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = new Options();

		options.addOption(new Option("log", "logger", false,
				"set logger on/off"));

		boolean loggerState = false;

		CommandLineParser parser = new PosixParser();

		try {
			CommandLine line = parser.parse(options, args);
			if (line.hasOption("logger")) {
				System.out.println("Logger on!");
				loggerState = true;
			}
			// Der Lexer wird mit einer Text-Datei instanziert, die Java-Quellcode enthält.
			MyLexer lexer = new MyLexer(
					new File(".").getAbsolutePath() + "/src/fhbi/maw/csas/lexer/source.txt"
					, loggerState);
			GUI gui = new GUI(lexer.getHtmlSource(), loggerState);
			gui.showAndCenter();
		} catch (ParseException e) {
			System.err.println("Invalid command line options: Exiting!");
		} catch (FileNotFoundException e) {
			System.err.println("Example file missing: Exiting!");;
		}

	}

}