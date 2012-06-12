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
	 * @param name Name des Token für Debuggingzwecke
	 * @param regexString Der reguläre Ausdruck
	 * @param htmlColor Schriftfarbe in einer möglichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer möglichen HTML-Darstellung
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
