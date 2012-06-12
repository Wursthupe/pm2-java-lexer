/**
 * 
 */
package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt primitive Datentypen
 * (boolean|char|byte|short|int|long|float|double)
 * @author Wursthupe
 */
public class TPrimitiveDataTypes extends Regex {

	public TPrimitiveDataTypes() {
		super("TPrimitiveDataTypes", "\\A\\s*(boolean|char|byte|short|int|long|float|double)", "purple", "b");
	}

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TPrimitiveDataTypes(String name, String regexString,
			String htmlColor, String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
	}
}
