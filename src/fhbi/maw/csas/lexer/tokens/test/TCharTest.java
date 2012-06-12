package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TChar;

public class TCharTest {

	private String expr_true, expr_false, expr_expected;
	private TChar tchar;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		expr_true = "   'bla';\n";
		expr_false = " s   'bla';\n";
		expr_expected = "   'bla'";
		
		tchar = new TChar();
	}
	
	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TChar#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tchar.startsWithRegex(expr_true);
		assertTrue("True expected", tchar.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TChar#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tchar.startsWithRegex(expr_true));
		assertFalse("False Expression", tchar.startsWithRegex(expr_false));
	}

}
