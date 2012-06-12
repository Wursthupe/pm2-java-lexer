package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt Strings
 * @author Wursthupe
 */
public class TString extends Regex{

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TString(String name, String expression, String htmlColor,
			String htmlArt) {
		super(name, expression, htmlColor, htmlArt);
	}

	public TString() {
		super("Strings", "\\A\\s*\".*?\"", "blue");
	}
}