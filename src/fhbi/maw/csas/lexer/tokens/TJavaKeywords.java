/**
 * 
 */
package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt die Javaschl�sselw�rter import|class|interface|extends|implements|public|private|protected|final|static|void|return|if|else|while|try|catch|finally
 * @author Wursthupe
 *
 */
public class TJavaKeywords extends Regex {

	public TJavaKeywords() {
		super("TJavaKeywords", "\\A\\s*(package|import|class|interface|extends|implements|public|private|protected|final|static|void|return|if|else|while|try|catch|finally|true|false)", "purple", "b");
	}

	/**
	 * @param name Name des Token f�r Debuggingzwecke
	 * @param regexString Der regul�re Ausdruck
	 * @param htmlColor Schriftfarbe in einer m�glichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer m�glichen HTML-Darstellung
	 */
	public TJavaKeywords(String name, String regexString, String htmlColor,
			String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
	}
}
