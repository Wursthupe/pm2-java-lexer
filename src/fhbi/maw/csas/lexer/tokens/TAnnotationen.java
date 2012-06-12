package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt Annotationen
 * @author Wursthupe
 */
public class TAnnotationen extends Regex {

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TAnnotationen(String name, String expression, String htmlColor,
			String htmlArt) {
		super(name, expression, htmlColor, htmlArt);
	}

	public TAnnotationen() {
		super("Annontation", "\\A\\s*\\@.*\n", "gray");
	}
}
