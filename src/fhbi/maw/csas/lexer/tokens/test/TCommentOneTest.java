/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TCommentOne;

/**
 * @author Wursthupe
 *
 */
public class TCommentOneTest {
	
	private String expr_true, expr_false, expr_expected;
	private TCommentOne tco;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expr_true = "	// Einzeiliger Kommentar\nasdfasdgferg";
		
		expr_false = "s	// Einzeiliger Kommentar";
		
		expr_expected = "	// Einzeiliger Kommentar\n";
		
		tco = new TCommentOne();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TCommentOne#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tco.startsWithRegex(expr_true);
		assertTrue("True expected", tco.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TCommentOne#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tco.startsWithRegex(expr_true));
		assertFalse("False Expression", tco.startsWithRegex(expr_false));
	}

}
