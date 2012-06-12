package fhbi.maw.csas.lexer;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Der Lexer wird mit einer Text-Datei instanziert, die Java-Quellcode enthält.
		MyLexer lexer;
		try {
			lexer = new MyLexer(
					new File(".").getAbsolutePath() + "/src/fhbi/maw/csas/lexer/source.txt");
			GUI gui = new GUI(lexer.getHtmlSource());
			gui.showAndCenter();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: Exiting!");
		}
	}

}