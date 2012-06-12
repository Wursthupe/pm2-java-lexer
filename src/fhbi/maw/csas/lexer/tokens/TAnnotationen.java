package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt Annotationen
 * @author Wursthupe
 */
public class TAnnotationen extends Regex {

	/**
	 * @param name Name des Token für Debuggingzwecke
	 * @param regexString Der reguläre Ausdruck
	 * @param htmlColor Schriftfarbe in einer möglichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer möglichen HTML-Darstellung
	 */
	public TAnnotationen(String name, String expression, String htmlColor,
			String htmlArt) {
		super(name, expression, htmlColor, htmlArt);
	}

	public TAnnotationen() {
		super("Annontation", "\\A\\s*\\@.*\n", "gray");
	}
}
