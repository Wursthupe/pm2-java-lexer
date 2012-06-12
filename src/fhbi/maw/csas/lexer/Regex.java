package fhbi.maw.csas.lexer;

/**
 * Diese Klasse beschreibt reguläre Ausdrücke.
 * Zusätzlich können in den Konstruktoren HTML-Formatierungen
 * festgelegt werden. 
 * 
 * @author Alexander Sundermann
 * @author Christian Stührmann
 * @version 1.0
 */
public abstract class Regex {
	
	// Name des Token (für Debuggingzwecke brauchbar)
	private String _name;
	
	// der reguläre Ausdruck
	private String _regexString;
	
	// Zeichenkette, die auf den reg. Ausdruck passt
	private String _expression;
	
	// Farbe für HTML-Darstellung
	private String _htmlColor;
	
	// Stil für HTML-Darstellung
	private String _htmlArt;
	
	/**
	 * Erzeugt eine Instanz mit übergebenen Parametern und der Schriftfarbe schwarz.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regulären Ausdruckes
	 */
	public Regex(String name, String regexString) {
		this(name, regexString, "black");
	}
	
	/**
	 * Erzeugt eine Instanz mit übergebenen Parametern.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regulären Ausdruckes
	 * @param htmlColor Schriftfarbe in der HTML-Ansicht
	 */
	public Regex(String name, String regexString, String htmlColor) {
		this._name = name;
		this._regexString = regexString;
		this._htmlColor = htmlColor;
	}
	
	/**
	 * Erzeugt eine Instanz mit übergebenen Parametern.
	 * 
	 * @param name Name des Regex-Objektes
	 * @param regexString Ausdruck des Regulären Ausdruckes
	 * @param htmlColor Schriftfarbe in der HTML-Ansicht
	 * @param htmlArt HTML-Stil Flag, (i und b)
	 */
	public Regex(String name, String regexString, String htmlColor, String htmlArt) {
		this(name, regexString, htmlColor);
		this._htmlArt = htmlArt;
	}
	
	/**
	 * Diese Mthode gibt den Regulären Ausdruck des Objekts als String wieder.
	 * 
	 * @return Regulärer Ausdruck des Objekts
	 */
	public String getRegexAsString() {
		return _regexString;
	}
	/**
	 * Diese Methode gibt den Namen des Regulären Ausdrucks wieder
	 * 
	 * @return Name des Regex-Objektes
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Zeichenkette, die zu diesem regulären Ausdruck passt, kann hiermit
	 * festgehalten werden.
	 * <br>
	 * Diese Methode wird von startsWithRegex() aufgerufen, wenn eine Zeichenkette
	 * diesen regulären Ausdruck am Anfang findet!
	 * 
	 * @param expression Gefundener Ausdruck in der Zeichenkette
	 */
	public void setExpression(String expression) {
		this._expression = expression;
	}

	/**
	 * Gibt die gespeicherte Zeichenkette, passend zum regulären Ausdruck, wieder
	 * 
	 * @return gefundener Ausdruck in der Zeichenkette, wenn festegelegt. Sonst "" (leerer String)
	 */
	public String getExpression() {
		if (_expression != null)
			return _expression;

		return "";
	}
	
	/**
	 * Überprüft, ob der eigene reguläre Ausruck auf den Anfang der übergebenen
	 * Zeichenkette passt.
	 * Ist dies der Fall, wird die gefundene Zeichenkette in diesem Objekt
	 * mit {@link #setExpression(String)} gespeichert.
	 * 
	 * @param expression die zu überprüfende Zeichenkette
	 * @return true, wenn der reg. Ausdruck auf den Anfang passt, sonst false
	 */
	public boolean startsWithRegex(String expression) {
		int len_exp = expression.length();
		
		String temp = expression.replaceFirst(getRegexAsString(), "");
		int len_temp = temp.length();
		
		if (len_exp > len_temp) {
			String sub = expression.substring(0, len_exp - len_temp);
			
			if (expression.startsWith(sub)) {
				setExpression(sub);
				return true;
			}
		}

		return false;
	}
}