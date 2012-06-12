/**
 * 
 */
package fhbi.maw.csas.lexer.tokens;

import fhbi.maw.csas.lexer.Regex;

/**
 * Dieses Token erkennt die Javaschlüsselwörter import|class|interface|extends|implements|public|private|protected|final|static|void|return|if|else|while|try|catch|finally
 * @author Wursthupe
 *
 */
public class TJavaKeywords extends Regex {

	public TJavaKeywords() {
		super("TJavaKeywords", "\\A\\s*(package|import|class|interface|extends|implements|public|private|protected|final|static|void|return|if|else|while|try|catch|finally|true|false)", "purple", "b");
	}

	/**
	 * @param name Name des Token für Debuggingzwecke
	 * @param regexString Der reguläre Ausdruck
	 * @param htmlColor Schriftfarbe in einer möglichen HTML-Darstellung
	 * @param htmlArt Schriftdekorierer in einer möglichen HTML-Darstellung
	 */
	public TJavaKeywords(String name, String regexString, String htmlColor,
			String htmlArt) {
		super(name, regexString, htmlColor, htmlArt);
	}
}
