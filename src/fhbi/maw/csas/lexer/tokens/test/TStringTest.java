/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TString;

/**
 * @author Wursthupe
 *
 */
public class TStringTest {

	private String expr_true, expr_false, expr_expected;
	private TString tstring;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		expr_true = "  \".\").getAbsolutePath() + \"/src/fhbi/maw/csas/lexer/\");\n";
		expr_false = " s  \".\").getAbsolutePath() + \"/src/fhbi/maw/csas/lexer/\");\n";
		expr_expected = "  \".\"";
		
		tstring = new TString();
	}
	
	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TString#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tstring.startsWithRegex(expr_true);
		assertTrue("True expected", tstring.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TString#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tstring.startsWithRegex(expr_true));
		assertFalse("False Expression", tstring.startsWithRegex(expr_false));
	}

}
