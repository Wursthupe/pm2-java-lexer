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
	 * @param name Name des Token für Debuggingzwecke
	 * @param regexString Der reguläre Ausdruck
	 * @param htmlColor Schriftfarbe in einer möglichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer möglichen HTML-Darstellung
	 */
	public TPrimitiveDataTypes(String name, String regexString,
			String htmlColor, String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
	}
}
