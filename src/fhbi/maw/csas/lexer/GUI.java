package fhbi.maw.csas.lexer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Eine sehr simpel gehaltene GUI, die HTML-Dokumente darstellen kann
 * 
 * @author Alexander Sundermann
 * @author Christian Stührmann
 * @version 1.0
 */
public class GUI{
	private JFrame mainFrame;
	
	//public class JEditorPane extends JTextComponent
	private JTextPane labelHtml;
	
	// Editor Kit zur Darstellung von HTML
	private HTMLEditorKit htmlEditor;
	
	// Scollbalken erstellen
	private JScrollPane jScrollPane;
	
	// Lexer, welcher die eingelesene Datei parst
	private MyLexer lexer;
	
	/*
	 * Ein Button um Dateien auszuwählen, welche geparst und
	 * angezeigt werden sollen
	 */
	private JButton btnReadFile;
	
	/**
	 * Beim erzeugen dieser Klasse wird ein mainFrame- Objekt instanziert, mit dem Namen" HTML Ausgabe".
	 * Zusätzlich wird dem mainFrame ein FlowLayout übergeben.
	 * Ist wird ein HTMLframe erzeugt mit dem Objekt JTextPane. Das HTMLframe wird in ein ScrollPane übergeben,
	 * um den HTML Text vollständig erkennen zu können.
	 * 
	 * Damit ein HTML Quellcode angezeigt werden kann, muss ein Objekt der Klasse HTMLEditorKit erzugt werden und
	 * dem HTMLframe übergeben werden.
	 * 
	 * Für den ScrollPane werden die Grenzen durch die Dimension-Instanz gesetzt.
	 * 
	 * Da dieses Musster dem Dekorier-Pattern enspricht und das unterste Muster das ScollPane ist,
	 * wird dieses als letztes dem mainFrame übergeben.
	 */
	public GUI(final boolean logging) {
		mainFrame = new JFrame("Quelltext mit Syntaxhighlighting");
		mainFrame.setLayout(new FlowLayout()); // FrameLout setzen
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Editor Kit erzeugen
		htmlEditor = new HTMLEditorKit();

		labelHtml = new JTextPane();
		labelHtml.setToolTipText("HTML Token");
		labelHtml.setEditorKit(htmlEditor);
		
		jScrollPane = new JScrollPane(labelHtml);
	  	jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  	jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainFrame.add(jScrollPane);
		
		btnReadFile = new JButton("Datei einlesen und Parsen");
		btnReadFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(
						new File(".").getAbsolutePath() + "/src/fhbi/maw/csas/lexer/");
			    int returnVal = chooser.showOpenDialog(mainFrame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	File file = chooser.getSelectedFile();
			    	try {
						lexer = new MyLexer(file.getAbsolutePath(), logging);
					} catch (FileNotFoundException e1) {
						actionPerformed(e);
					}
			    	setWindowText(lexer.getHtmlSource());
			    }
			}
		});
		mainFrame.add(btnReadFile);
	}
	
	/**
	 * Ruft den parameterlosen Kontruktor auf und setzt Fenstertext
	 * @param htmlSource
	 */
	public GUI(String htmlSource, boolean logging) {
		this(logging);
		setWindowText(htmlSource);
	}
	
	// zeigt den übergebenen String im Textfenster an
	private void setWindowText(String htmlSource) {
		labelHtml.setText(htmlSource);
	}
	
	/**
	 * Fenster zentriert anzeigen
	 */
	public void showAndCenter() {
		// Fenster anzeigen
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		// Bildschirmgröße auslesen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 
		// Rechne neue Position aus (zentriert)
		int w = mainFrame.getSize().width;
		int h = mainFrame.getSize().height;
		int x = (screenSize.width-w)/2;
		int y = (screenSize.height-h)/2;
		 
		// Fenster bewegen
		mainFrame.setLocation(x, y);
	}
}
