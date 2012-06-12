/**
 * 
 */
package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt ein Zeilenende mit/ohne vorhergehenden Leerzeichen
 * @author Wursthupe
 */
public class TEndLine extends Regex {

	public TEndLine() {
		super("EndLine", "\\A\\s*\n");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TEndLine(String name, String regexString, String htmlColor,
			String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
	}

	@Override
	public String getHTMLTag() {
		return "<br>";
	}
}
