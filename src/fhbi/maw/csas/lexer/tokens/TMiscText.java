/**
 * 
 */
package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt jedes Zeichen.
 * @author Wursthupe
 */
public class TMiscText extends Regex {

	public TMiscText() {
		super("MiscText", "\\A\\s*.{1}");
	}

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TMiscText(String name, String regexString, String htmlColor,
			String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
		// TODO Auto-generated constructor stub
	}
}
