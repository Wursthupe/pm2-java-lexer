package fhbi.maw.csas.lexer;

/**
 * Diese Klasse beschreibt regul�re Ausdr�cke.
 * Zus�tzlich k�nnen in den Konstruktoren HTML-Formatierungen
 * festgelegt werden. 
 * 
 * @author Alexander Sundermann
 * @author Christian St�hrmann
 * @version 1.0
 */
public abstract class Regex {
	
	// Name des Token (f�r Debuggingzwecke brauchbar)
	private String _name;
	
	// der regul�re Ausdruck
	private String _regexString;
	
	// Zeichenkette, die auf den reg. Ausdruck passt
	private String _expression;
	
	// Farbe f�r HTML-Darstellung
	private String _htmlColor;
	
	// Stil f�r HTML-Darstellung
	private String _htmlArt;
	
	/**
	 * Erzeugt eine Instanz mit �bergebenen Parametern und der Schriftfarbe schwarz.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regul�ren Ausdruckes
	 */
	public Regex(String name, String regexString) {
		this(name, regexString, "black");
	}
	
	/**
	 * Erzeugt eine Instanz mit �bergebenen Parametern.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regul�ren Ausdruckes
	 * @param htmlColor Schriftfarbe in der HTML-Ansicht
	 */
	public Regex(String name, String regexString, String htmlColor) {
		this._name = name;
		this._regexString = regexString;
		this._htmlColor = htmlColor;
	}
	
	/**
	 * Erzeugt eine Instanz mit �bergebenen Parametern.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regul�ren Ausdruckes
	 * @param htmlColor Schriftfarbe in der HTML-Ansicht
	 * @param htmlArt HTML-Stil Flag, (i und b)
	 */
	public Regex(String name, String regexString, String htmlColor, String htmlArt) {
		this(name, regexString, htmlColor);
		this._htmlArt = htmlArt;
	}
	
	/**
	 * Diese Mthode gibt den Regul�ren Ausdruck des Objekts als String wieder.
	 * 
	 * @return Regul�rer Ausdruck des Objekts
	 */
	public String getRegexAsString() {
		return _regexString;
	}
	/**
	 * Diese Methode gibt den Namen des Regul�ren Ausdrucks wieder
	 * 
	 * @return Name des Regex-Objektes
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Zeichenkette, die zu diesem regul�ren Ausdruck passt, kann hiermit
	 * festgehalten werden.
	 * <br>
	 * Diese Methode wird von startsWithRegex() aufgerufen, wenn eine Zeichenkette
	 * diesen regul�ren Ausdruck am Anfang findet!
	 * 
	 * @param expression Gefundener Ausdruck in der Zeichenkette
	 */
	public void setExpression(String expression) {
		this._expression = expression;
	}

	/**
	 * Gibt die gespeicherte Zeichenkette, passend zum regul�ren Ausdruck, wieder
	 * 
	 * @return gefundener Ausdruck in der Zeichenkette, wenn festegelegt. Sonst "" (leerer String)
	 */
	public String getExpression() {
		if (_expression != null)
			return _expression;

		return "";
	}
}