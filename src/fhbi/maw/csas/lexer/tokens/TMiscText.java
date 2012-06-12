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
	 * @param name Name des Token für Debuggingzwecke
	 * @param regexString Der reguläre Ausdruck
	 * @param htmlColor Schriftfarbe in einer möglichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer möglichen HTML-Darstellung
	 */
	public TMiscText(String name, String regexString, String htmlColor,
			String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
		// TODO Auto-generated constructor stub
	}
}
