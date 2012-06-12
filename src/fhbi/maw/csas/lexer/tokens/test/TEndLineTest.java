/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TEndLine;

/**
 * @author Wursthupe
 *
 */
public class TEndLineTest {
	
	private String expr_true, expr_false, expr_expected;
	private TEndLine tel;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expr_true = "  \nasdfasdgferg";
		
		expr_false = "s  \nasdfasdgferg";
		
		expr_expected = "  \n";
		
		tel = new TEndLine();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TEndLine#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tel.startsWithRegex(expr_true);
		assertTrue("True expected", tel.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TEndLine#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tel.startsWithRegex(expr_true));
		assertFalse("False Expression", tel.startsWithRegex(expr_false));
	}

}
