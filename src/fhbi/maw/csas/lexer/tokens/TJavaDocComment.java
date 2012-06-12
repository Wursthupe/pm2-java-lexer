package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt Javadoc-Kommentare
 * @author Wursthupe
 */
public class TJavaDocComment extends Regex {

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TJavaDocComment(String name, String expression, String htmlColor,
			String htmlArt) {
		super(name, expression, htmlColor, htmlArt);
	}

	public TJavaDocComment() {
		//						"\\A\\s*/\\*{2}([^\\*]|\\*(?!/))*?.*?\\*/"
		super("JavaDocComment", "\\A\\s*/\\*{2}([^\\*]|\\*(?!/))*?.*?\\*/", "#00BFFF");
	}
}