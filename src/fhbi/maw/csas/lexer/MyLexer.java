package fhbi.maw.csas.lexer;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import fhbi.maw.csas.lexer.tokens.TAnnotationen;
import fhbi.maw.csas.lexer.tokens.TChar;
import fhbi.maw.csas.lexer.tokens.TCommentMore;
import fhbi.maw.csas.lexer.tokens.TCommentOne;
import fhbi.maw.csas.lexer.tokens.TEndLine;
import fhbi.maw.csas.lexer.tokens.TJavaDocComment;
import fhbi.maw.csas.lexer.tokens.TJavaKeywords;
import fhbi.maw.csas.lexer.tokens.TMiscText;
import fhbi.maw.csas.lexer.tokens.TPrimitiveDataTypes;
import fhbi.maw.csas.lexer.tokens.TString;

/**
 * Die Klasse MyLexer implementiert einen Lexer, der den eingelesenden Quellcode
 * analysiert und als Token-Liste im HTML Layout ausgibt.
 * 
 * @author Alexander Sundermann
 * @author Christian Stührmann
 * @version 1.0
 */
public class MyLexer {
	private BufferedReader _source;
	private ArrayList<Regex> foundRegex_List;
	private String sourceString;

	/**
	 * Dies ist der Konstruktor der MyLexer - Klasse. Beim initalisieren muss
	 * ein String oder File-Objekt übergeben werden, in dem der Pfad einer
	 * TXT-Datei, die Java Quelltext enthält.
	 * 
	 * Diese Datei wird an einen BufferedReader übergeben, um zeilenweise
	 * verarbeitet werden zu können. Bei der Initialisierung dieses Objektes
	 * wird die Datei automatisch ausgelesen und verarbeitet.
	 * 
	 * @param source
	 *            Pfad der Quellcode Text-Datei
	 * @exception FileNotFoundException
	 *                Diese Exeption wird geworfen, wenn der Pfad nicht passt
	 *                bzw. Die Quelltext Datei nicht existiert.
	 */
	public MyLexer(String source) throws FileNotFoundException {
		this._source = new BufferedReader(new FileReader(source));

		foundRegex_List = new ArrayList<Regex>();

		try {
			readStringfromFile();
			findRegex();
		} catch (MyException exception) {
			System.err.printf("\n%s", exception.getMessage());
			foundRegex_List = new ArrayList<Regex>();
			Regex missMatch = new Regex("MissMatch", "", "red", "b") {
			};
			missMatch.setExpression(exception.getMessage());
			foundRegex_List.add(missMatch);
		}
	}

	// Liest die Quelldatei als String ein
	private void readStringfromFile() {
		sourceString = "";
		String str;
		try {
			while ((str = _source.readLine()) != null)
				sourceString += str + "\n";
		} catch (IOException e) {
			System.err.println("Source file couldn't be read. Exiting...");
			System.exit(1);
		}
	}

	/**
	 * Dieses Methode sucht in dem erzeugten String nach Zeichenketten, die auf
	 * die Regulären Ausdrücken passen. Falls ein Token gefunden wird, wird ein
	 * neues Objekt des gefunden Tokens initalisiert und die gefundene
	 * Zeichenkette wird in das Objekt geschrieben und aus dem erzeugten String
	 * gelöscht.
	 * 
	 * @throws EOFException
	 *             Wird ausgelöst, wenn kein Token zuständig war und der
	 *             Quelltext noch nicht abgearbeitet ist.
	 * @throws MyException
	 */
	private void findRegex() throws MyException {
		boolean end = false;
		String temp = "";
		while (!end) {
			end = true;
			for (Regex regex : getRegexCheckList()) {
				if (regex.startsWithRegex(sourceString)) {
					end = false;
					foundRegex_List.add(regex);
					sourceString = sourceString.replaceFirst(
							regex.getRegexAsString(), "");
					break;
				}
			}

			if (end && !sourceString.equals(""))
				throw new MyException();
		}
	}

	/**
	 * Erstellt eine Token-Hierarchie, in der ein Stream auf Tokens überprüft
	 * wird
	 * 
	 * @return die Hierarchie als Liste
	 */
	public ArrayList<Regex> getRegexCheckList() {
		ArrayList<Regex> regexToCheck_List = new ArrayList<Regex>();

		regexToCheck_List.add(new TEndLine());
		regexToCheck_List.add(new TJavaDocComment());
		regexToCheck_List.add(new TCommentOne());
		regexToCheck_List.add(new TCommentMore());
		regexToCheck_List.add(new TString());
		regexToCheck_List.add(new TChar());
		regexToCheck_List.add(new TAnnotationen());
		regexToCheck_List.add(new TJavaKeywords());
		regexToCheck_List.add(new TPrimitiveDataTypes());
		regexToCheck_List.add(new TMiscText());

		return regexToCheck_List;
	}
	
	/**
	 * Diese Methode erzeugt ein HTML-Gerüst mit "HTML und BODY" Teil der HTML -
	 * Standarts. Dieser String kann in einem HTML Viewer angezeigt werden.
	 */
	public String getHtmlSource() {
		String str = "";
		for (Regex regex : foundRegex_List)
			str = str + regex.getHTMLTag();

		return str;
	}
}
