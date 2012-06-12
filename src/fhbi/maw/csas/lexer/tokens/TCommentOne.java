package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt einzeilige Kommentare
 * @author Wursthupe
 *
 */
public class TCommentOne extends Regex {

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TCommentOne(String name, String expression, String htmlColor,
			String htmlArt) {
		super(name, expression, htmlColor, htmlArt);
	}

	public TCommentOne() {
		super("TCommentOne", "\\A\\s*//.*\n", "green", "i");
	}
}
